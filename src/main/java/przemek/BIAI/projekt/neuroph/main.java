/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSetRow;

import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.LMS;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Przemek
 */
public class main {

    public static void main(String[] args) throws InterruptedException {

        MyDataSet DSdax150 = new MyDataSet();
        DataFileHandler dax150Loader = new DataFileHandler();
        dax150Loader.loadData("DAX150.txt", DSdax150, 160);

        //System.out.println(DSdax150);
        MyDataSet set = new MyDataSet();

        DataSetCollection dataSetCollectionForTeaching = new DataSetCollection();
        dataSetCollectionForTeaching.addDataSet(DSdax150, 5, new Integer[]{0, 1}, 1, new Integer[]{0, 1}, 1);  // tu mozna by przekazywac arraylist a nie data loadera
        //     dataSetCollectionForTeaching.addDataSet(DSdax150, 2, new int[]{0, 2}, 2, new int[]{ 1, 2},0);
        //     System.out.println(dataSetCollectionForTeaching.dataSets.get(0));
        //   dataSetCollectionForTeaching.normalize();
        //   dataSetCollectionForTeaching.backNormalization();

        //   dax150Loader.saveDataSetCollectinForTest(dataSetCollectionForTeaching, 3,1,result, "saveTestResult.txt");
        //    dax150Loader.dotToComma("saveTestResult.txt");
        System.out.println(dataSetCollectionForTeaching.dataSets.get(0));

        System.out.println(dataSetCollectionForTeaching.dataSets.get(0));

        TrainingData trainingData = new TrainingData();
        trainingData.prepareLearningSet(dataSetCollectionForTeaching, 10,2);
        dataSetCollectionForTeaching.normalize();
        trainingData.prepareLearningSet(dataSetCollectionForTeaching, 20,4);
        trainingData.prepareTestingSet(dataSetCollectionForTeaching, 5, 0);

        int maxIterations = 10000;
        MultiLayerPerceptron myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.TANH, 10, 21, 21, 2);
        myMlPerceptron.getLearningRule().setMaxError(0.001);//0-1
        myMlPerceptron.getLearningRule().setLearningRate(0.1);//0-1
        myMlPerceptron.getLearningRule().setMaxIterations(maxIterations);//0-1

        System.out.println("learnign stuff");
        for (int i = 0; i < 10; i++) {
            System.out.println(trainingData.learningSet.getRowAt(i).toString());
        }
        myMlPerceptron.learn(trainingData.learningSet);

        double[][] result = new double[5][trainingData.testingSet.size()];

        DataSetRow dataRow;
        for (int i = 0; i < trainingData.testingSet.size(); i++) {
            dataRow = trainingData.testingSet.getRowAt(i);
            System.out.println("\n");
            System.out.println("First dataSet " + dataRow.toString());
            myMlPerceptron.setInput(dataRow.getInput());
            myMlPerceptron.calculate();
            result[i] = myMlPerceptron.getOutput().clone();

            for (int j = 0; j < result[i].length; j++) {
                System.out.println("First result !!!! " + result[i][j]);
            }

        }

        dataSetCollectionForTeaching.backNormalizatfionInResult(result);

        System.out.println("KUPA");
    }
}
