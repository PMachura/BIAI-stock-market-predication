/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.util.ArrayList;




public class DataSetCollection {

    ArrayList<MyDataSet> dataSets;
    /**
     * Maximum test or train elements which can be created by single MyDataSet,
     * reachable for each MyDataSet of this DataSetCollection It is equal the
     * smallest value of: MyDataSet.maxDataPortionNumber of each MyDataSet of
     * this DataSetCollection
     */
    int maxDataPortionNumber;

    public DataSetCollection() {
        dataSets = new ArrayList<MyDataSet>();
    }

    /**
     * Adds the DataSet with specified parameters which detremines the
     * TrainingData how to handle with this dataSet.
     *
     * @param InputMyDataSet set of Data
     * @param dataInput means how much of single data should act as a single
     * input for the network
     * @param dataOutput means how much of single data should act as a singe
     * output for the network
     *
     */
    public void addDataSet(MyDataSet InputMyDataSet, int dataInputNumber, Integer[] dataInputIndicator, int dataOutputNumber, Integer[] dataOutputIndicator, int inOutDataDistance) throws Exception {

        InputMyDataSet.calculateMaxValuesNumber();

        int dataPortionNumber = dataInputNumber + dataOutputNumber;

        if (dataPortionNumber > InputMyDataSet.data.size()) {
            throw new Exception("[DataSetCollection,addDataSet] dataPortionNumber> MyDataSet.size()");
        } else if (dataInputIndicator.length > InputMyDataSet.maxValuesNumber || dataOutputIndicator.length > InputMyDataSet.maxValuesNumber) {
            throw new Exception("[DataSetCollection,addDataSet] valuesNumber>MyDataSet.maxValuesNumber");
        } else {
            MyDataSet dataSet = new MyDataSet(InputMyDataSet);
            dataSet.setInOutNumbers(dataInputNumber, dataInputIndicator, dataOutputNumber, dataOutputIndicator, inOutDataDistance);
            if (dataSet.checkValuesIndicator() == 1) {
                dataSets.add(dataSet);
            } else {
                throw new Exception("[DataSetCollection,addDataSet] dataSet.checkValuesIndicator error");
            }

        }

    }

    public void normalize() {
        for (MyDataSet dataSet : dataSets) {
            dataSet.normalize();
        }
    }
    

    public void backNormalization() {
        for (MyDataSet dataSet : dataSets) {
            dataSet.backNormalize();
        }
    }
    
    public void normalizeSimple(){
        for (MyDataSet dataSet : dataSets) {
            dataSet.normalizeSimple();
        }
    }
    
     public void backNormalizationSimple() {
        for (MyDataSet dataSet : dataSets) {
            dataSet.backNormalizeSimple();
        }
    }
    
    

    public void backNormalizationInResult(double[][] result) {
        ArrayList<Double> maximumValues = new ArrayList<Double>();
        for (MyDataSet dataSet : dataSets) {
            System.out.println("Values indicator lenght: " + dataSet.outValuesIndicator.length);
            System.out.println(dataSet.outValuesIndicator[0]);
            System.out.println(dataSet.maximumValues[dataSet.outValuesIndicator[0]]);
            for (int j = 0; j < dataSet.dataOutputValuesNumber; j++) {
                maximumValues.add(dataSet.maximumValues[dataSet.outValuesIndicator[j]]);
            }

        }
        System.out.println("Result set back normalization process");

        System.out.println("Result leng " + result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.println("Row: ");
            System.out.println("Result[i] " + result[i].length);
            int indicator = 0;
            for (int j = 0; j < result[i].length; j++) {

                result[i][j] = result[i][j] * maximumValues.get(indicator) / 0.8;   
                System.out.print(result[i][j] + " ");
                indicator++;
                if (indicator == maximumValues.size()) {
                    indicator = 0;
                }
            }

        }
    }
    
    public void backNormalizationInResultSimple(double [][] result){
        
       ArrayList<Double> maximumValues = new ArrayList<Double>();
       for (MyDataSet dataSet : dataSets) {
           for (int j = 0; j < dataSet.dataOutputValuesNumber; j++) {
                maximumValues.add(dataSet.maximumValue);
            }
       }
        
        
        for(int i = 0 ; i < result.length ; i ++){
            int indicator = 0;
            for(int j =0; j <result[i].length ; j ++){
                result[i][j] = result[i][j] * maximumValues.get(indicator) / 0.8;
                System.out.print(result[i][j] + " ");
                indicator++;
                if (indicator == maximumValues.size()) {
                    indicator = 0;
                }
            }
        }
    }

    public int findMaximumDataPortion() throws Exception {

        if (dataSets.size() == 0) {
            throw new Exception("[DataSetCollection,finMaximumDataPortion] dataSets.size=0");
        }
        int min = dataSets.get(0).maxDataPortionNumber;
        for (MyDataSet dataSet : dataSets) {
            if (dataSet.maxDataPortionNumber < min) {
                min = dataSet.maxDataPortionNumber;
            }
        }
        maxDataPortionNumber = min;
        return maxDataPortionNumber;

    }

    @Override
    public String toString() {
        return "DataSetCollection{" + "dataSets=" + dataSets + '}';
    }

}
