/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.util.ArrayList;
import org.neuroph.nnet.MultiLayerPerceptron;

/**
 *
 * @author Przemek
 */
public class Complex {
    String name;
    DataSetCollection dataSetCollection = new DataSetCollection();
    ArrayList<TrainingData> trainingDatas = new ArrayList<TrainingData>();
    ArrayList<MultiLayerPerceptron> networks = new ArrayList<MultiLayerPerceptron>();
}
