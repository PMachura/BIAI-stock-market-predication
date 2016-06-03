/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.util.TransferFunctionType;
//import org.neuroph.core.learning.SupervisedTrainingElement;
//import org.neuroph.core.learning.TrainingElement;
//import org.neuroph.core.learning.TrainingSet;

/**
 *
 * @author Przemek
 */
public class TrainingData {

    DataSet learningSet;
    DataSet testingSet;

    public TrainingData() {

    }

    public void prepareLearningSet(DataSetCollection dataSetCollection, int trainingElementAmount, int startingRow) {

        // tu mozna wszedzie foreache zapakowac -.- ale ze mnie down
        int inputValuesDataNumber = 0;
        int outputValuesDataNumber = 0;
        for (int i = 0; i < dataSetCollection.dataSets.size(); i++) {
            outputValuesDataNumber += dataSetCollection.dataSets.get(i).dataOutputValuesNumber * dataSetCollection.dataSets.get(i).dataOutputNumber;
            //  System.out.println("OUT" + outputValuesDataNumber);
            inputValuesDataNumber += dataSetCollection.dataSets.get(i).dataInputValuesNumber * dataSetCollection.dataSets.get(i).dataInputNumber;;
            //   System.out.println("IN" + inputValuesDataNumber);
        }
        learningSet = new DataSet(inputValuesDataNumber, outputValuesDataNumber);  //tutaj jest problem

        // ilosc zestawow treninowych tzn ilosc roznych zestawow wejsc dla sieci
        try {
            for (int i = 0; i < trainingElementAmount; i++) {

                ArrayList<Double> input = new ArrayList<Double>();
                ArrayList<Double> output = new ArrayList<Double>();

                for (MyDataSet dataSet : dataSetCollection.dataSets) { //to mozna przestawic wyzej zeby tu tego nie cisnac caly czas

                    if (dataSet.maxDataPortionNumber < trainingElementAmount + startingRow) {
                        throw new Exception("[TrainingData,prepareTrainingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

                    } else {
                        for (int k = 0; k < dataSet.dataInputNumber; k++) {
                            for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                                input.add(dataSet.data.get(i + k + startingRow).values[dataSet.inValuesIndicator[l]]);
                                //  System.out.println("iput[" + l + "] " + input.get(l));
                            }

                        }
                        for (int k = 0; k < dataSet.dataOutputNumber; k++) {
                            for (int l = 0; l < dataSet.dataOutputValuesNumber; l++) {
                                output.add(dataSet.data.get(i + k + dataSet.dataInputNumber + dataSet.inOutDataDistance + startingRow).values[dataSet.outValuesIndicator[l]]);
                            }

                        }

                    }
                }
                learningSet.addRow(new DataSetRow(input, output));
                System.out.println("Input for teach  " + input);
                System.out.println("Output for teach " + output);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void prepareTestingSet(DataSetCollection dataSetCollection, int trainingElementAmount, int startingRow) {
        int inputDataNumber = 0;
        for (int i = 0; i < dataSetCollection.dataSets.size(); i++) {
            inputDataNumber += dataSetCollection.dataSets.get(i).dataInputValuesNumber * dataSetCollection.dataSets.get(i).dataInputNumber;
        }
        testingSet = new DataSet(inputDataNumber);
        try {
            for (int i = 0; i < trainingElementAmount; i++) {

                ArrayList<Double> input = new ArrayList<Double>();
                for (MyDataSet dataSet : dataSetCollection.dataSets) {
                    if (dataSet.maxDataPortionNumber < (trainingElementAmount + startingRow)) {
                        // EXCETPION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        throw new Exception("[TrainingData,prepareTestingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

                    } else {
                        for (int k = 0; k < dataSet.dataInputNumber; k++) {
                            for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                                input.add(dataSet.data.get(i + k + startingRow).values[dataSet.inValuesIndicator[l]]);
                                //  System.out.println("iput[" + l + "] " + input.get(l));
                            }

                        }
                    }

                }
                System.out.println("Input for test" + input);
                testingSet.addRow(new DataSetRow(input));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
