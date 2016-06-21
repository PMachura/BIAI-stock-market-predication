/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;

/**
 * Represents single row loaded from file
 *
 * @author Przemek
 */
class SingleData {

    /**
     * Date
     */
    String date;
    /**
     * Index value
     */
    double[] values;

    public SingleData(String date, double[] values) {
        this.date = date;
        this.values = values.clone();

    }

    public SingleData(SingleData data) {
        this.values = data.values.clone();
        this.date = data.date;
    }

    public double findMax() {
        double max = 0;
        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }
        System.out.println("max " + max);
        return max;

    }

    @Override
    public String toString() {
        String s = "SingleData{" + "date=" + date + " ";
        for (double v : values) {
            s += (Double.toString(v) + " ");
        }
        return s;
    }

}

/**
 * Loads data from file Data are saved as an SingleData objects
 *
 * @author Przemek
 */
public class DataFileHandler {

    public DataFileHandler() {

    }

   
    /**
     * Load all data from the file. Save data to arrayList of SingleData Data
     * must have the specified stucture Main Title 1_param_description,
     * 2_param_description, 3_param_description ... param 1, param 2 ,param3
     * Example: Example_set date, index_low, index_high 2015-5-5, 78,79
     * 2015-5-6, 80,79 ...
     *
     * @param fileName
     */
    void loadData(String fileName, MyDataSet myDataSet) throws Exception {

        File file = new File(fileName);
        System.out.println("File for DataLoader = " + fileName);

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int valuesNumber = 0;
        int counter = 0;


        /*Wczytujemy opis zestawu danych */
        if ((line = br.readLine()) != null) {
            myDataSet.descriptor = line;
            System.out.println("[DataLoader,loadData] MyDataSet.descriptor loaded");
        } else {
            throw new Exception("[DataLoader, loadData] Can't load myDataSet.descriptor");
        }
        /* Wczytujemy opis poszczegolnych wartosci */
        if ((line = br.readLine()) != null) {
            String[] loaded = line.split(",");
            myDataSet.singleDataValuesDescriptor = loaded.clone();
            valuesNumber = myDataSet.singleDataValuesDescriptor.length;
            System.out.println("[DataLoader,loadData] MyDataSet.singleDataValuesDescriptor loaded. SingleData should have: " + (valuesNumber - 1) + " values and 1 descriptor fe: date");
        } else {
            throw new Exception("[DataLoader, loadData] Can't load myDataSet.singleDataValuesDescriptor");
        }

        /*Wczytujemy dane */
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            String[] loaded = line.split(",");

            if (loaded.length == valuesNumber) {
                String[] trimed = new String[loaded.length];
                double[] trimedDouble = new double[loaded.length - 1];
                int i = 0;
                for (String s : loaded) {
                    trimed[i] = s.trim();
                    i++;
                }
                for (i = 1; i < trimed.length; i++) {
                    trimedDouble[i - 1] = Double.parseDouble(trimed[i]);
                }

                SingleData singleData = new SingleData(trimed[0], trimedDouble);
                myDataSet.data.add(singleData);

                counter++;
            } else {
                throw new Exception("[DataLoader,loadData] ValuesNumber missmatch ");
            }

        }
        br.close();
        fis.close();
        System.out.println("[DataLoader,loadData] Data loaded correctly: " + counter);

    }

    /**
     * Load requested amount of data from the file. Save data to arrayList of
     * SingleData
     *
     * @param fileName
     */
    void loadData(String fileName, MyDataSet myDataSet, int rowNumber) throws Exception {

        File file = new File(fileName);
        System.out.println("File for DataLoader = " + fileName);

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int valuesNumber;

        int counter = 0;


        /*Wczytujemy opis zestawu danych */
        if ((line = br.readLine()) != null) {
            myDataSet.descriptor = line;
            System.out.println("[DataLoader,loadData] MyDataSet.descriptor loaded");
        } else {
            throw new Exception("[DataLoader, loadData] Can't load myDataSet.descriptor");
        }
        /* Wczytujemy opis poszczegolnych wartosci */
        if ((line = br.readLine()) != null) {
            String[] loaded = line.split(",");
            myDataSet.singleDataValuesDescriptor = loaded.clone();
            valuesNumber = myDataSet.singleDataValuesDescriptor.length;
            System.out.println("[DataLoader,loadData] MyDataSet.singleDataValuesDescriptor loaded. SingleData should have: " + (valuesNumber - 1) + " values and 1 descriptor fe: date");
        } else {
            throw new Exception("[DataLoader, loadData] Can't load myDataSet.singleDataValuesDescriptor");
        }

        for (int i = 0; i < rowNumber; i++) {
            line = br.readLine();
            if (line != null) {
                String[] loaded = line.split(",");
                if (loaded.length == valuesNumber) {
                    String[] trimed = new String[loaded.length];
                    double[] trimedDouble = new double[loaded.length - 1];
                    int j = 0;
                    for (String s : loaded) {
                        trimed[j] = s.trim();
                        j++;
                    }
                    for (j = 1; j < trimed.length; j++) {

                        trimedDouble[j - 1] = Double.parseDouble(trimed[j]);

                    }
                    SingleData singleData = new SingleData(trimed[0], trimedDouble);
                    myDataSet.data.add(singleData);
                } else {
                    throw new Exception("[DataLoader,loadData] ValuesNumber missmatch ");
                }
            } else {
                // Exception
                throw new Exception("[DataLoader,loadData] The file has not enough rows. Requested: " + rowNumber + " Loaded: " + myDataSet.data.size());
            }
        }

        br.close();
        fis.close();

        System.out.println("[DataLoader,loadData] Data loaded correctly: " + rowNumber);

    }

    public void dotToComma(String fileName) throws IOException {

        File file = new File(fileName.replace(".txt", "_1.txt"));
        FileWriter fw = new FileWriter(file);

        Reader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            //fw.write(br.readLine().replaceAll("\\.","olo" ) + "\n");

            System.out.print(br.readLine().replaceAll("\\.", "olo") + "\n");
        }

        fw.close();
        br.close();
        fr.close();

    }

    public void saveDataSetCollectinForTrain(DataSetCollection dataSetCollection, int trainingElementAmount, String fileName) throws Exception {

        // ilosc zestawow treninowych tzn ilosc roznych zestawow wejsc dla sieci
        PrintWriter out = new PrintWriter(fileName);

        out.println("Data sets descriptors");
        for (MyDataSet dataSet : dataSetCollection.dataSets) {
            out.println(dataSet.descriptor);
        }

        String input = "";
        String output = "";
        // out.println("\n");
        out.println("Single data values descriptors");
        for (MyDataSet dataSet : dataSetCollection.dataSets) { //to mozna przestawic wyzej zeby tu tego nie cisnac caly czas

            if (dataSet.maxDataPortionNumber < trainingElementAmount) {
                throw new Exception("[TrainingData,prepareTrainingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

            } else {

                //  out.println("");
                //  out.println("In values descriptor");
                for (int k = 0; k < dataSet.dataInputNumber; k++) {
                    for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                        input += (dataSet.singleDataValuesDescriptor[dataSet.inValuesIndicator[l] + 1] + "\t");

                    }
                }

                //out.print("\t");
                //out.println("Out values descriptor");
                for (int k = 0; k < dataSet.dataOutputNumber; k++) {
                    for (int l = 0; l < dataSet.dataOutputValuesNumber; l++) {
                        output += (dataSet.singleDataValuesDescriptor[dataSet.outValuesIndicator[l] + 1] + "\t");
                    }
                }

            }
        }
        out.print(input);
        out.print("\t");
        out.print(output);

        out.println("\n");
        out.println("Values from all data set for single trainingElement");
        for (int i = 0; i < trainingElementAmount; i++) {

            input = "";
            output = "";

            for (MyDataSet dataSet : dataSetCollection.dataSets) { //to mozna przestawic wyzej zeby tu tego nie cisnac caly czas

                if (dataSet.maxDataPortionNumber < trainingElementAmount) {
                    throw new Exception("[TrainingData,prepareTrainingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

                } else {
                    for (int k = 0; k < dataSet.dataInputNumber; k++) {
                        for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                            input += Double.toString(dataSet.data.get(i + k).values[dataSet.inValuesIndicator[l]]) + "\t";
                            //  System.out.println("iput[" + l + "] " + input.get(l));
                        }

                    }
                    for (int k = 0; k < dataSet.dataOutputNumber; k++) {
                        for (int l = 0; l < dataSet.dataOutputValuesNumber; l++) {
                            output += Double.toString(dataSet.data.get(i + k + dataSet.dataInputNumber + dataSet.inOutDataDistance).values[dataSet.outValuesIndicator[l]]) + "\t";
                        }

                    }

                }
            }

            out.print(input + "\t");
            out.print(output + "\t");
            out.println("\n");  //zeby podczas zczytywania odczytac w pliku tekstowym pusta linie, ktora bedzie pelnic role odstepu 

        }
        out.close();

    }

    
    // training Element amount jest niepotrzebne, bo mozna to wywynioskowac z tablicy wynikow - z jej rozmiaru
    public void saveDataSetCollectinForTest(DataSetCollection dataSetCollection, int trainingElementAmount, String startingDate, double[][] results, String fileName) throws Exception {

        PrintWriter out = new PrintWriter(fileName);

        out.println("Data sets descriptors");// Z jakich zestawow danych zostala utworzona siec np. Dax,Oil, Gold
        for (MyDataSet dataSet : dataSetCollection.dataSets) {
            out.println(dataSet.descriptor);
        }

        String input = "";
        String output = "";
        String tabulator = "";
        // out.println("\n");
        

        out.println("Single data values descriptors"); //Podajemy z ktorych konkretnie elementow zbiorow danych wypisanych powyzej zbudowana jest siec(Np . dax - open, high)
        for (MyDataSet dataSet : dataSetCollection.dataSets) { //to mozna przestawic wyzej zeby tu tego nie cisnac caly czas

            if (dataSet.maxDataPortionNumber < trainingElementAmount) {
                throw new Exception("[TrainingData,prepareTrainingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

            } else {

                //  out.println("");
                //  out.println("In values descriptor");
                for (int k = 0; k < dataSet.dataInputNumber; k++) {
                    for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                        input += (dataSet.singleDataValuesDescriptor[dataSet.inValuesIndicator[l] + 1] + "\t");

                    }
                }

                //out.print("\t");
                //out.println("Out values descriptor");
                for (int k = 0; k < dataSet.dataOutputNumber; k++) {
                    for (int l = 0; l < dataSet.dataOutputValuesNumber; l++) {
                        output += (dataSet.singleDataValuesDescriptor[dataSet.outValuesIndicator[l] + 1] + "\t");
                    }
                }

            }
        }
        out.print(input); //tutaj wypisujemy wyliczone wczesniej nazwy skladnikow przypadajace na wejscie sieci
        out.print("\t");
        out.print(output); // tutaj wypisujemy nazwy skladnikow, jakie przypadaja na wyjscia sieci

        
        ArrayList<Integer> startingRow = new ArrayList<Integer>();
        for (MyDataSet dataSet : dataSetCollection.dataSets) {
            startingRow.add(dataSet.calculateStartingElement(startingDate));
        }
        
        out.println("\n");
        out.println("Values from all data set for single trainingElement"); // wartosci 
        for (int i = 0; i < trainingElementAmount; i++) {

            input = "";
            output = "";
            
            Integer dataSetIndicator = 0;
            for (MyDataSet dataSet : dataSetCollection.dataSets) { //to mozna przestawic wyzej zeby tu tego nie cisnac caly czas

                if (dataSet.maxDataPortionNumber < (trainingElementAmount + startingRow.get(dataSetIndicator))) {
                    throw new Exception("[TrainingData,prepareTrainingSet] , trainingElementAmount greater then DataSet.maxDataPortionNumber");

                } else { //wypisujemy wartosci jakie zostaly uzyte w celu przewidywania wyniku
                    for (int k = 0; k < dataSet.dataInputNumber; k++) {
                        for (int l = 0; l < dataSet.dataInputValuesNumber; l++) {
                            input += Double.toString(dataSet.data.get(i + k + startingRow.get(dataSetIndicator)).values[dataSet.inValuesIndicator[l]]) + "\t";
                            //  System.out.println("iput[" + l + "] " + input.get(l));
                            tabulator += "\t";
                        }

                    }
                    /* wypisujemy wartosci bedace prawidlowym wynikiem - teoretycznie nie powinnismy ich znac bo sa to wartosci, ktore przewidujemy
                       ale jest to testowy program akademicki, w celu weryfikacji dzialania sieci testujemy wartosci, ktore znamy */      
                    for (int k = 0; k < dataSet.dataOutputNumber; k++) { 
                        for (int l = 0; l < dataSet.dataOutputValuesNumber; l++) {
                            output += Double.toString(dataSet.data.get(i + k + dataSet.dataInputNumber + dataSet.inOutDataDistance + startingRow.get(dataSetIndicator)).values[dataSet.outValuesIndicator[l]]) + "\t";
                        }

                    }

                }
                dataSetIndicator ++;
            }

            out.print(input + "\t");
            out.print(output);
            out.println();

            tabulator += "\t";
            out.print(tabulator);
            for (int m = 0; m < results[i].length; m++) {
                out.print(Double.toString(results[i][m]) + "\t");  // wypisujemy rezultat wyniku jaki otrzymalismy tuz pod wynikiem prawdziwym
            }
            tabulator = "";
            out.println("\n");  //zeby podczas zczytywania odczytac w pliku tekstowym pusta linie, ktora bedzie pelnic role odstepu 

        }
        out.close();

    }

   

}
