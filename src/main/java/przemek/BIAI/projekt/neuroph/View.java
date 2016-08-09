/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

/**
 *
 * @author Przemek
 */
public class View extends javax.swing.JFrame {

    DataFileHandler dataFileHandler = new DataFileHandler();
    DataSetCollection dataSetCollection = new DataSetCollection();
    MyDataSet dax = new MyDataSet();
    MyDataSet oil = new MyDataSet();
    MyDataSet gold = new MyDataSet();
    TrainingData trainingData = new TrainingData();
    MultiLayerPerceptron network;
    double[][] result;
    boolean isLearningSet = false;
    boolean isTestingSet = false;
    boolean isNetwork = false;
    boolean isLearnde = false;

   

    /**
     * Creates new form View
     */
    public View() {

        initComponents();
        try {
            dataFileHandler.loadData("DAX300.txt", dax);
            dataFileHandler.loadData("CrudeOil300.txt", oil);
            dataFileHandler.loadData("Gold300.txt", gold);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Collections.reverse(dax.data);
        Collections.reverse(oil.data);
        Collections.reverse(gold.data);

        for (Integer i = 0; i < 100; i++) {
            jComboBoxCrudeOilInputNumber.addItem(i.toString());
            jComboBoxDaxInputNumber.addItem(i.toString());
            jComboBoxGoldInputNumber.addItem(i.toString());

            jComboBoxCrudeOilOutputNumber.addItem(i.toString());
            jComboBoxDaxOutputNumber.addItem(i.toString());
            jComboBoxGoldOutputNumber.addItem(i.toString());

            jComboBoxDaxInOutDistance.addItem(i.toString());
            jComboBoxCrudeOilInOutDistance.addItem(i.toString());
            jComboBoxGoldInOutDistance.addItem(i.toString());

            jComboBoxLearningElementsAmount.addItem(i.toString());
            jComboBoxTestingElementsAmount.addItem(i.toString());

        }

        ArrayList<String> daxDate = new ArrayList<String>(0);
        for (SingleData sd : dax.data) {
            daxDate.add(sd.date);
        }

        ArrayList<String> goldDate = new ArrayList<String>(0);
        for (SingleData sd : gold.data) {
            goldDate.add(sd.date);
        }

        ArrayList<String> oilDate = new ArrayList<String>(0);
        for (SingleData sd : oil.data) {
            oilDate.add(sd.date);
        }

        ArrayList<String> avaliableDate = new ArrayList<String>();

        for (String s : daxDate) {
            if (goldDate.contains(s) && oilDate.contains(s)) {
                avaliableDate.add(s);
            }
        }

        for (String s : avaliableDate) {
            jComboBoxLearningStartElement.addItem(s);
            jComboBoxTestingStartElement.addItem(s);
        }

    }

    private Integer[] getDaxInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] inputIndicators;
        if (jCheckBoxDaxInputOpen.isSelected()) {
            inputValuesIndicator.add(0);
        }
        if (jCheckBoxDaxInputHigh.isSelected()) {
            inputValuesIndicator.add(1);
        }
        if (jCheckBoxDaxInputLow.isSelected()) {
            inputValuesIndicator.add(2);
        }
        if (jCheckBoxDaxInputClose.isSelected()) {
            inputValuesIndicator.add(3);
        }

        inputIndicators = new Integer[inputValuesIndicator.size()];
        for (int i = 0; i < inputIndicators.length; i++) {
            inputIndicators[i] = inputValuesIndicator.get(i);
        }
        return inputIndicators;
    }

    private Integer[] getOilInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] inputIndicators;
        if (jCheckBoxCrudeOilInputOpen.isSelected()) {
            inputValuesIndicator.add(0);
        }
        if (jCheckBoxCrudeOilInputHigh.isSelected()) {
            inputValuesIndicator.add(1);
        }
        if (jCheckBoxCrudeOilInputLow.isSelected()) {
            inputValuesIndicator.add(2);
        }
        if (jCheckBoxCrudeOilInputClose.isSelected()) {
            inputValuesIndicator.add(3);
        }

        inputIndicators = new Integer[inputValuesIndicator.size()];
        for (int i = 0; i < inputIndicators.length; i++) {
            inputIndicators[i] = inputValuesIndicator.get(i);
        }
        return inputIndicators;
    }

    private Integer[] getGoldInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] inputIndicators;
        if (jCheckBoxGoldInputOpen.isSelected()) {
            inputValuesIndicator.add(0);
        }
        if (jCheckBoxGoldInputHigh.isSelected()) {
            inputValuesIndicator.add(1);
        }
        if (jCheckBoxGoldInputLow.isSelected()) {
            inputValuesIndicator.add(2);
        }
        if (jCheckBoxGoldInputClose.isSelected()) {
            inputValuesIndicator.add(3);
        }

        inputIndicators = new Integer[inputValuesIndicator.size()];
        for (int i = 0; i < inputIndicators.length; i++) {
            inputIndicators[i] = inputValuesIndicator.get(i);
        }
        return inputIndicators;
    }

    private Integer[] getDaxOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] outputIndicators;
        if (jCheckBoxDaxOutputOpen.isSelected()) {
            outputValuesIndicator.add(0);
        }
        if (jCheckBoxDaxOutputHigh.isSelected()) {
            outputValuesIndicator.add(1);
        }
        if (jCheckBoxDaxOutputLow.isSelected()) {
            outputValuesIndicator.add(2);
        }
        if (jCheckBoxDaxOutputClose.isSelected()) {
            outputValuesIndicator.add(3);
        }

        outputIndicators = new Integer[outputValuesIndicator.size()];
        for (int i = 0; i < outputIndicators.length; i++) {
            outputIndicators[i] = outputValuesIndicator.get(i);
        }
        return outputIndicators;
    }

    private Integer[] getOilOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] outputIndicators;
        if (jCheckBoxCrudeOilOutputOpen.isSelected()) {
            outputValuesIndicator.add(0);
        }
        if (jCheckBoxCrudeOilOutputHigh.isSelected()) {
            outputValuesIndicator.add(1);
        }
        if (jCheckBoxCrudeOilOutputLow.isSelected()) {
            outputValuesIndicator.add(2);
        }
        if (jCheckBoxCrudeOilOutputClose.isSelected()) {
            outputValuesIndicator.add(3);
        }

        outputIndicators = new Integer[outputValuesIndicator.size()];
        for (int i = 0; i < outputIndicators.length; i++) {
            outputIndicators[i] = outputValuesIndicator.get(i);
        }
        return outputIndicators;
    }

    private Integer[] getGoldOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);
        Integer[] outputIndicators;
        if (jCheckBoxGoldOutputOpen.isSelected()) {
            outputValuesIndicator.add(0);
        }
        if (jCheckBoxGoldOutputHigh.isSelected()) {
            outputValuesIndicator.add(1);
        }
        if (jCheckBoxGoldOutputLow.isSelected()) {
            outputValuesIndicator.add(2);
        }
        if (jCheckBoxGoldOutputClose.isSelected()) {
            outputValuesIndicator.add(3);
        }

        outputIndicators = new Integer[outputValuesIndicator.size()];
        for (int i = 0; i < outputIndicators.length; i++) {
            outputIndicators[i] = outputValuesIndicator.get(i);
        }
        return outputIndicators;
    }

    public void setLabelsButtonsAfterDataSetCreation() {

        jButtonCreateNetwork.setEnabled(true);
        jButtonPrepareLearningSet.setEnabled(true);
        jButtonPrepareTestingSet.setEnabled(true);
        jButtonLearnNetwork.setEnabled(false);
        jButtonTestNetwork.setEnabled(false);

        jLabelCreateDataSetCollection.setText("Created");
        jLabelPrepareLearningSet.setText("Not prepared");
        jLabelPrepareTestingSet.setText("Not prepared");
        
        isLearningSet = false;
        isTestingSet = false;
        
    }

    public void setLabelsButtonsAfterNetworkCreation() {
        jLabelTestNetwork.setText("Not tested");
        jLabelLearnNetwork.setText("Not learned");
        jLabelLoadNetwork.setText("Not loaded");
        jLabelSaveNetwork.setText("Not saved");
        jLabelCreateNetwork.setText("Created");
        
        isNetwork=true;
        isLearnde=false;
        if(isNetwork && isLearningSet){
            jButtonLearnNetwork.setEnabled(true);
        }
        
        if(isNetwork && isTestingSet){
            jButtonTestNetwork.setEnabled(true);
        }
    }
    
    public void setLabelsButtonsAfterPreparingLearningSet(){
        jLabelPrepareLearningSet.setText("Prepared");
        isLearningSet = true;
        if(isNetwork && isLearningSet){
            jButtonLearnNetwork.setEnabled(true);
        }
        
    }
    
    public void setLabelsButtonsAfterPreparingTestingSet(){
        jLabelPrepareTestingSet.setText("Prepared");
        isTestingSet = true;
        
        if(isNetwork && isTestingSet && isLearnde){
            jButtonTestNetwork.setEnabled(true);
        }
    }

    public void setLabelsButtonsAfterNetworkLoading(){
        isNetwork = true;
        isLearnde = true;
        if(isNetwork && isLearningSet){
            jButtonLearnNetwork.setEnabled(true);
        }
        if(isNetwork && isTestingSet){
            jButtonTestNetwork.setEnabled(true);
        }
        
        jLabelTestNetwork.setText("Not tested");
        jLabelSaveNetwork.setText("Not saved");
        jLabelLoadNetwork.setText("Loaded");
        jLabelCreateNetwork.setText("Not created");
    }
    
    public void setLabelsButtonsAfterNetworkSaving(){
        jLabelSaveNetwork.setText("Saved");
    }
    
    public void setLabelsButtonsAfterNetworkTesting(){
        jLabelTestNetwork.setText("Tested");
    }
    
    public void setLabelsButtonsAfterNetworkLearning(){
        isLearnde = true;
        jLabelLearnNetwork.setText("Learned");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxDaxInputOpen = new javax.swing.JCheckBox();
        jCheckBoxDaxInputHigh = new javax.swing.JCheckBox();
        jCheckBoxDaxInputLow = new javax.swing.JCheckBox();
        jCheckBoxDaxInputClose = new javax.swing.JCheckBox();
        jCheckBoxDaxInputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxDaxInputVolumen = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxDaxOutputOpen = new javax.swing.JCheckBox();
        jCheckBoxDaxOutputHigh = new javax.swing.JCheckBox();
        jCheckBoxDaxOutputLow = new javax.swing.JCheckBox();
        jCheckBoxDaxOutputClose = new javax.swing.JCheckBox();
        jCheckBoxDaxOutputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxDaxOutputVolumen = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilOutputLow = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBoxCrudeOilOutputClose = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jCheckBoxCrudeOilOutputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilOutputVolumen = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBoxCrudeOilInputOpen = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilInputHigh = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilInputLow = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilInputClose = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilInputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilOutputOpen = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilInputVolumen = new javax.swing.JCheckBox();
        jCheckBoxCrudeOilOutputHigh = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputLow = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputClose = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputVolumen = new javax.swing.JCheckBox();
        jCheckBoxGoldInputVolumen = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBoxGoldInputOpen = new javax.swing.JCheckBox();
        jCheckBoxGoldInputHigh = new javax.swing.JCheckBox();
        jCheckBoxGoldInputLow = new javax.swing.JCheckBox();
        jCheckBoxGoldInputClose = new javax.swing.JCheckBox();
        jCheckBoxGoldInputAdjacent = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputOpen = new javax.swing.JCheckBox();
        jCheckBoxGoldOutputHigh = new javax.swing.JCheckBox();
        jButtonCreateDataSetCollection = new javax.swing.JButton();
        jCheckBoxDax = new javax.swing.JCheckBox();
        jCheckBoxCrudeOil = new javax.swing.JCheckBox();
        jCheckBoxGold = new javax.swing.JCheckBox();
        jButtonPrepareLearningSet = new javax.swing.JButton();
        jButtonPrepareTestingSet = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMaxIterations = new javax.swing.JTextField();
        jTextFieldLearningRate = new javax.swing.JTextField();
        jTextFieldMaxError = new javax.swing.JTextField();
        jTextFieldLayers = new javax.swing.JTextField();
        jComboBoxDaxInputNumber = new javax.swing.JComboBox<>();
        jComboBoxDaxOutputNumber = new javax.swing.JComboBox<>();
        jComboBoxCrudeOilOutputNumber = new javax.swing.JComboBox<>();
        jComboBoxCrudeOilInputNumber = new javax.swing.JComboBox<>();
        jComboBoxGoldOutputNumber = new javax.swing.JComboBox<>();
        jComboBoxGoldInputNumber = new javax.swing.JComboBox<>();
        jComboBoxDaxInOutDistance = new javax.swing.JComboBox<>();
        jComboBoxCrudeOilInOutDistance = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxGoldInOutDistance = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxTestingStartElement = new javax.swing.JComboBox<>();
        jComboBoxLearningElementsAmount = new javax.swing.JComboBox<>();
        jComboBoxTestingElementsAmount = new javax.swing.JComboBox<>();
        jComboBoxLearningStartElement = new javax.swing.JComboBox<>();
        jButtonCreateNetwork = new javax.swing.JButton();
        jButtonLearnNetwork = new javax.swing.JButton();
        jButtonTestNetwork = new javax.swing.JButton();
        jLabelCreateDataSetCollection = new javax.swing.JLabel();
        jLabelPrepareLearningSet = new javax.swing.JLabel();
        jLabelPrepareTestingSet = new javax.swing.JLabel();
        jLabelCreateNetwork = new javax.swing.JLabel();
        jButtonLoadNetwork = new javax.swing.JButton();
        jButtonSaveNetwork = new javax.swing.JButton();
        jTextFieldLoadNetworkFile = new javax.swing.JTextField();
        jTextFieldSaveNetworkFile = new javax.swing.JTextField();
        jLabelLoadNetwork = new javax.swing.JLabel();
        jLabelSaveNetwork = new javax.swing.JLabel();
        jLabelLearnNetwork = new javax.swing.JLabel();
        jTextFieldTestFileName = new javax.swing.JTextField();
        jLabelTestNetwork = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBoxDaxInputOpen.setSelected(true);
        jCheckBoxDaxInputOpen.setText("Open");
        jCheckBoxDaxInputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaxInputOpenActionPerformed(evt);
            }
        });

        jCheckBoxDaxInputHigh.setText("High");
        jCheckBoxDaxInputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaxInputHighActionPerformed(evt);
            }
        });

        jCheckBoxDaxInputLow.setText("Low");

        jCheckBoxDaxInputClose.setText("Close");
        jCheckBoxDaxInputClose.setEnabled(false);

        jCheckBoxDaxInputAdjacent.setText("Adjacent");
        jCheckBoxDaxInputAdjacent.setEnabled(false);

        jCheckBoxDaxInputVolumen.setText("Volumen");
        jCheckBoxDaxInputVolumen.setEnabled(false);

        jLabel1.setText("Input number");

        jLabel2.setText("Output number");

        jLabel3.setText("In out distance");

        jLabel4.setText("Input");

        jLabel5.setText("Output");

        jCheckBoxDaxOutputOpen.setSelected(true);
        jCheckBoxDaxOutputOpen.setText("Open");
        jCheckBoxDaxOutputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaxOutputOpenActionPerformed(evt);
            }
        });

        jCheckBoxDaxOutputHigh.setText("High");
        jCheckBoxDaxOutputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDaxOutputHighActionPerformed(evt);
            }
        });

        jCheckBoxDaxOutputLow.setText("Low");

        jCheckBoxDaxOutputClose.setText("Close");
        jCheckBoxDaxOutputClose.setEnabled(false);

        jCheckBoxDaxOutputAdjacent.setText("Adjacent");
        jCheckBoxDaxOutputAdjacent.setEnabled(false);

        jCheckBoxDaxOutputVolumen.setText("Volumen");
        jCheckBoxDaxOutputVolumen.setEnabled(false);

        jCheckBoxCrudeOilOutputLow.setText("Low");

        jLabel6.setText("Input number");

        jCheckBoxCrudeOilOutputClose.setText("Close");
        jCheckBoxCrudeOilOutputClose.setEnabled(false);

        jLabel7.setText("Output number");

        jCheckBoxCrudeOilOutputAdjacent.setText("Adjacent");
        jCheckBoxCrudeOilOutputAdjacent.setEnabled(false);

        jCheckBoxCrudeOilOutputVolumen.setText("Volumen");
        jCheckBoxCrudeOilOutputVolumen.setEnabled(false);

        jLabel8.setText("Input");

        jLabel9.setText("Output");

        jCheckBoxCrudeOilInputOpen.setSelected(true);
        jCheckBoxCrudeOilInputOpen.setText("Open");
        jCheckBoxCrudeOilInputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilInputOpenActionPerformed(evt);
            }
        });

        jCheckBoxCrudeOilInputHigh.setText("High");
        jCheckBoxCrudeOilInputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilInputHighActionPerformed(evt);
            }
        });

        jCheckBoxCrudeOilInputLow.setText("Low");

        jCheckBoxCrudeOilInputClose.setText("Close");
        jCheckBoxCrudeOilInputClose.setEnabled(false);

        jCheckBoxCrudeOilInputAdjacent.setText("Adjacent");
        jCheckBoxCrudeOilInputAdjacent.setEnabled(false);

        jCheckBoxCrudeOilOutputOpen.setText("Open");
        jCheckBoxCrudeOilOutputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilOutputOpenActionPerformed(evt);
            }
        });

        jCheckBoxCrudeOilInputVolumen.setText("Volumen");
        jCheckBoxCrudeOilInputVolumen.setEnabled(false);

        jCheckBoxCrudeOilOutputHigh.setText("High");
        jCheckBoxCrudeOilOutputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilOutputHighActionPerformed(evt);
            }
        });

        jCheckBoxGoldOutputLow.setText("Low");

        jCheckBoxGoldOutputClose.setText("Close");
        jCheckBoxGoldOutputClose.setEnabled(false);

        jCheckBoxGoldOutputAdjacent.setText("Adjacent");
        jCheckBoxGoldOutputAdjacent.setEnabled(false);

        jCheckBoxGoldOutputVolumen.setText("Volumen");
        jCheckBoxGoldOutputVolumen.setEnabled(false);

        jCheckBoxGoldInputVolumen.setText("Volumen");
        jCheckBoxGoldInputVolumen.setEnabled(false);

        jLabel10.setText("Input number");

        jLabel11.setText("Output number");

        jLabel12.setText("Input");

        jLabel13.setText("Output");

        jCheckBoxGoldInputOpen.setSelected(true);
        jCheckBoxGoldInputOpen.setText("Open");
        jCheckBoxGoldInputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGoldInputOpenActionPerformed(evt);
            }
        });

        jCheckBoxGoldInputHigh.setText("High");
        jCheckBoxGoldInputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGoldInputHighActionPerformed(evt);
            }
        });

        jCheckBoxGoldInputLow.setText("Low");

        jCheckBoxGoldInputClose.setText("Close");
        jCheckBoxGoldInputClose.setEnabled(false);

        jCheckBoxGoldInputAdjacent.setText("Adjacent");
        jCheckBoxGoldInputAdjacent.setEnabled(false);

        jCheckBoxGoldOutputOpen.setText("Open");
        jCheckBoxGoldOutputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGoldOutputOpenActionPerformed(evt);
            }
        });

        jCheckBoxGoldOutputHigh.setText("High");
        jCheckBoxGoldOutputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGoldOutputHighActionPerformed(evt);
            }
        });

        jButtonCreateDataSetCollection.setText("Create data set collection");
        jButtonCreateDataSetCollection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCreateDataSetCollectionMouseClicked(evt);
            }
        });

        jCheckBoxDax.setSelected(true);
        jCheckBoxDax.setText("DAX");

        jCheckBoxCrudeOil.setSelected(true);
        jCheckBoxCrudeOil.setText("Crude Oil");

        jCheckBoxGold.setSelected(true);
        jCheckBoxGold.setText("Gold");

        jButtonPrepareLearningSet.setText("Prepare learning set");
        jButtonPrepareLearningSet.setEnabled(false);
        jButtonPrepareLearningSet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPrepareLearningSetMouseClicked(evt);
            }
        });
        jButtonPrepareLearningSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrepareLearningSetActionPerformed(evt);
            }
        });

        jButtonPrepareTestingSet.setText("Prepare testing set");
        jButtonPrepareTestingSet.setEnabled(false);
        jButtonPrepareTestingSet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPrepareTestingSetMouseClicked(evt);
            }
        });

        jLabel14.setText("Learning starting element ");

        jLabel15.setText("Testing starting element");

        jLabel16.setText("Learning elements amount");

        jLabel17.setText("Testing elements amount");

        jLabel18.setText("Learning rate");

        jLabel19.setText("Max error");

        jLabel20.setText("Max iterations");

        jLabel21.setText("Layers");

        jTextFieldMaxIterations.setText("10000");

        jTextFieldLearningRate.setText("0.1");

        jTextFieldMaxError.setText("0.001");

        jTextFieldLayers.setText("31,31,31");

        jComboBoxDaxInputNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDaxInputNumberActionPerformed(evt);
            }
        });

        jLabel22.setText("In out distance");

        jLabel23.setText("In out distance");

        jComboBoxTestingStartElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTestingStartElementActionPerformed(evt);
            }
        });

        jComboBoxLearningElementsAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLearningElementsAmountActionPerformed(evt);
            }
        });

        jComboBoxTestingElementsAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTestingElementsAmountActionPerformed(evt);
            }
        });

        jComboBoxLearningStartElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLearningStartElementActionPerformed(evt);
            }
        });

        jButtonCreateNetwork.setText("Create netowrk");
        jButtonCreateNetwork.setEnabled(false);
        jButtonCreateNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCreateNetworkMouseClicked(evt);
            }
        });
        jButtonCreateNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateNetworkActionPerformed(evt);
            }
        });

        jButtonLearnNetwork.setText("Learn");
        jButtonLearnNetwork.setEnabled(false);
        jButtonLearnNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLearnNetworkMouseClicked(evt);
            }
        });

        jButtonTestNetwork.setText("Test");
        jButtonTestNetwork.setEnabled(false);
        jButtonTestNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTestNetworkMouseClicked(evt);
            }
        });

        jLabelCreateDataSetCollection.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCreateDataSetCollection.setText("Not created");

        jLabelPrepareLearningSet.setForeground(new java.awt.Color(0, 0, 255));
        jLabelPrepareLearningSet.setText("Not created");

        jLabelPrepareTestingSet.setForeground(new java.awt.Color(0, 0, 255));
        jLabelPrepareTestingSet.setText("Not created");

        jLabelCreateNetwork.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCreateNetwork.setText("Not created");

        jButtonLoadNetwork.setText("Load network");
        jButtonLoadNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoadNetworkMouseClicked(evt);
            }
        });

        jButtonSaveNetwork.setText("Save network");
        jButtonSaveNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveNetworkMouseClicked(evt);
            }
        });

        jTextFieldLoadNetworkFile.setText("File name");

        jTextFieldSaveNetworkFile.setText("File name");

        jLabelLoadNetwork.setForeground(new java.awt.Color(0, 0, 255));
        jLabelLoadNetwork.setText("Not loaded");

        jLabelSaveNetwork.setForeground(new java.awt.Color(0, 0, 255));
        jLabelSaveNetwork.setText("Not saved");

        jLabelLearnNetwork.setForeground(new java.awt.Color(0, 0, 255));
        jLabelLearnNetwork.setText("Not learned");

        jTextFieldTestFileName.setText("File name");
        jTextFieldTestFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTestFileNameActionPerformed(evt);
            }
        });

        jLabelTestNetwork.setForeground(new java.awt.Color(0, 0, 255));
        jLabelTestNetwork.setText("Not tested");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(42, 42, 42)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .add(60, 60, 60)
                                .add(jLabel5))
                            .add(jCheckBoxDax)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jCheckBoxDaxInputClose)
                                    .add(jCheckBoxDaxInputOpen)
                                    .add(jCheckBoxDaxInputHigh)
                                    .add(jCheckBoxDaxInputLow)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jCheckBoxDaxInputAdjacent)
                                        .add(jCheckBoxDaxInputVolumen)))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jCheckBoxDaxOutputClose)
                                    .add(jCheckBoxDaxOutputAdjacent)
                                    .add(jCheckBoxDaxOutputVolumen)
                                    .add(jCheckBoxDaxOutputOpen)
                                    .add(jCheckBoxDaxOutputHigh)
                                    .add(jCheckBoxDaxOutputLow))
                                .add(34, 34, 34)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jLabel1)
                                    .add(jComboBoxDaxInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jComboBoxDaxOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jComboBoxDaxInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .add(jButtonCreateDataSetCollection)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabelCreateDataSetCollection, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(77, 77, 77)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jCheckBoxCrudeOil))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 279, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jCheckBoxGoldInputClose)
                                            .add(jCheckBoxGoldInputVolumen)
                                            .add(jCheckBoxGoldInputOpen)
                                            .add(jCheckBoxGoldInputHigh)
                                            .add(jCheckBoxGoldInputLow))
                                        .add(22, 22, 22))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jCheckBoxGoldInputAdjacent)
                                        .add(18, 18, 18))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel12)
                                        .add(61, 61, 61)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel13)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jCheckBoxGoldOutputAdjacent)
                                            .add(jCheckBoxGoldOutputClose)
                                            .add(jCheckBoxGoldOutputVolumen)
                                            .add(jCheckBoxGoldOutputOpen)
                                            .add(jCheckBoxGoldOutputHigh)
                                            .add(jCheckBoxGoldOutputLow))
                                        .add(34, 34, 34)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel11)
                                            .add(jLabel10)
                                            .add(jComboBoxGoldOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jComboBoxGoldInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jLabel23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jComboBoxGoldInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                            .add(jCheckBoxGold))
                        .add(58, 58, 58))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(348, 348, 348)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jCheckBoxCrudeOilInputVolumen)
                                        .add(22, 22, 22))
                                    .add(jCheckBoxCrudeOilInputClose)
                                    .add(jCheckBoxCrudeOilInputOpen)
                                    .add(jCheckBoxCrudeOilInputHigh)
                                    .add(jCheckBoxCrudeOilInputLow)
                                    .add(jCheckBoxCrudeOilInputAdjacent))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jCheckBoxCrudeOilOutputClose)
                                    .add(jCheckBoxCrudeOilOutputAdjacent)
                                    .add(jCheckBoxCrudeOilOutputOpen)
                                    .add(jCheckBoxCrudeOilOutputHigh)
                                    .add(jCheckBoxCrudeOilOutputLow)
                                    .add(jCheckBoxCrudeOilOutputVolumen)
                                    .add(jLabel9)))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel14))
                                .add(4, 4, 4)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jComboBoxLearningStartElement, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jComboBoxTestingStartElement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel16)
                                    .add(jLabel17))
                                .add(4, 4, 4)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComboBoxLearningElementsAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jComboBoxTestingElementsAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .add(jButtonPrepareLearningSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jLabelPrepareLearningSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jButtonPrepareTestingSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jLabelPrepareTestingSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel7)
                            .add(jLabel6)
                            .add(jComboBoxCrudeOilOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jComboBoxCrudeOilInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jComboBoxCrudeOilInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel19)
                                            .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(35, 35, 35))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jLabel18)
                                        .add(22, 22, 22)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextFieldLearningRate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .add(jTextFieldMaxError)
                                    .add(jTextFieldLayers)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldMaxIterations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(41, 41, 41)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(jButtonSaveNetwork, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButtonLoadNetwork, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButtonCreateNetwork, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(jButtonLearnNetwork, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButtonTestNetwork, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextFieldLoadNetworkFile)
                            .add(jTextFieldSaveNetworkFile)
                            .add(jTextFieldTestFileName))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelSaveNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabelLoadNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabelCreateNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabelLearnNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabelTestNetwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(48, 48, 48)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jCheckBoxGold)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jCheckBoxDax)
                        .add(jCheckBoxCrudeOil)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel4)
                                    .add(jLabel5))
                                .add(18, 18, 18)
                                .add(jCheckBoxDaxOutputOpen)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxOutputHigh)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxOutputLow)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxOutputClose)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jCheckBoxDaxInputVolumen)
                                    .add(jCheckBoxDaxOutputVolumen))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jCheckBoxDaxInputAdjacent)
                                    .add(jCheckBoxDaxOutputAdjacent)))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(32, 32, 32)
                                        .add(jCheckBoxDaxInputOpen))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jLabel1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jComboBoxDaxInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxInputHigh)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxInputLow)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxDaxInputClose)))
                        .add(8, 8, 8)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonCreateDataSetCollection)
                            .add(jLabelCreateDataSetCollection))
                        .add(44, 44, 44)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabelCreateNetwork)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel14)
                                .add(jComboBoxLearningElementsAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel16)
                                .add(jComboBoxLearningStartElement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jTextFieldMaxIterations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jButtonCreateNetwork))))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(32, 32, 32)
                                    .add(jCheckBoxGoldOutputOpen)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldOutputHigh)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldOutputLow)
                                    .add(33, 33, 33))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel10)
                                    .add(12, 12, 12)
                                    .add(jComboBoxGoldInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jLabel11)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jComboBoxGoldOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(12, 12, 12)))
                            .add(jLabel23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jComboBoxGoldInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                            .add(2, 2, 2)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel8)
                                .add(jLabel9)))
                        .add(layout.createSequentialGroup()
                            .add(10, 10, 10)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(layout.createSequentialGroup()
                                    .add(jCheckBoxCrudeOilInputOpen)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jLabel2)
                                        .add(jCheckBoxCrudeOilInputHigh))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxCrudeOilInputLow)
                                        .add(jComboBoxDaxOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(jCheckBoxCrudeOilInputClose)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(jCheckBoxCrudeOilInputVolumen))
                                        .add(layout.createSequentialGroup()
                                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jComboBoxDaxInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jCheckBoxCrudeOilInputAdjacent))
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(17, 17, 17)
                                            .add(jCheckBoxCrudeOilOutputOpen)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxCrudeOilOutputHigh)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxCrudeOilOutputLow)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxCrudeOilOutputClose)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(jCheckBoxCrudeOilOutputVolumen))
                                        .add(layout.createSequentialGroup()
                                            .add(jLabel6)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jComboBoxCrudeOilInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(14, 14, 14)
                                            .add(jLabel7)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jComboBoxCrudeOilOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(18, 18, 18)
                                            .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                    .add(3, 3, 3)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jComboBoxCrudeOilInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jCheckBoxCrudeOilOutputAdjacent)))
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel12)
                                        .add(jLabel13))
                                    .add(18, 18, 18)
                                    .add(jCheckBoxGoldInputOpen)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldInputHigh)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldInputLow)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxGoldInputClose)
                                        .add(jCheckBoxGoldOutputClose))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxGoldInputVolumen)
                                        .add(jCheckBoxGoldOutputVolumen))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxGoldInputAdjacent)
                                        .add(jCheckBoxGoldOutputAdjacent)))))))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel15)
                            .add(jComboBoxTestingStartElement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel17)
                            .add(jComboBoxTestingElementsAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonPrepareLearningSet)
                            .add(jLabelPrepareLearningSet))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonPrepareTestingSet)
                            .add(jLabelPrepareTestingSet)))
                    .add(layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel18)
                            .add(jTextFieldLearningRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel19)
                            .add(jTextFieldMaxError, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel21)
                            .add(jTextFieldLayers, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jButtonLoadNetwork)
                                .add(jTextFieldLoadNetworkFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabelLoadNetwork))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonLearnNetwork)
                            .add(jLabelLearnNetwork))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonTestNetwork)
                            .add(jTextFieldTestFileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabelTestNetwork))))
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonSaveNetwork)
                    .add(jTextFieldSaveNetworkFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelSaveNetwork))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxDaxInputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDaxInputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDaxInputOpenActionPerformed

    private void jCheckBoxDaxInputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDaxInputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDaxInputHighActionPerformed

    private void jCheckBoxDaxOutputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDaxOutputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDaxOutputOpenActionPerformed

    private void jCheckBoxDaxOutputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDaxOutputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxDaxOutputHighActionPerformed

    private void jCheckBoxCrudeOilInputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCrudeOilInputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCrudeOilInputOpenActionPerformed

    private void jCheckBoxCrudeOilInputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCrudeOilInputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCrudeOilInputHighActionPerformed

    private void jCheckBoxCrudeOilOutputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCrudeOilOutputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCrudeOilOutputOpenActionPerformed

    private void jCheckBoxCrudeOilOutputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCrudeOilOutputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCrudeOilOutputHighActionPerformed

    private void jCheckBoxGoldInputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGoldInputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGoldInputOpenActionPerformed

    private void jCheckBoxGoldInputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGoldInputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGoldInputHighActionPerformed

    private void jCheckBoxGoldOutputOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGoldOutputOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGoldOutputOpenActionPerformed

    private void jCheckBoxGoldOutputHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGoldOutputHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxGoldOutputHighActionPerformed

    private void jButtonCreateDataSetCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateDataSetCollectionMouseClicked

        Integer[] daxInputValuesIndicator = getDaxInputValuesIndicator();
        Integer[] goldInputValuesIndicator = getGoldInputValuesIndicator();
        Integer[] oilInputValuesIndicator = getOilInputValuesIndicator();

        Integer[] daxOutputValuesIndicator = getDaxOutputValuesIndicator();
        Integer[] goldOutputValuesIndicator = getGoldOutputValuesIndicator();
        Integer[] oilOutputValuesIndicator = getOilOutputValuesIndicator();

        Integer oilInputNumber = Integer.parseInt((String) jComboBoxCrudeOilInputNumber.getSelectedItem());
        Integer goldInputNumber = Integer.parseInt((String) jComboBoxGoldInputNumber.getSelectedItem());
        Integer daxInputNumber = Integer.parseInt((String) jComboBoxDaxInputNumber.getSelectedItem());

        Integer oilOutputNumber = Integer.parseInt((String) jComboBoxCrudeOilOutputNumber.getSelectedItem());
        Integer goldOutputNumber = Integer.parseInt((String) jComboBoxGoldOutputNumber.getSelectedItem());
        Integer daxOutputNumber = Integer.parseInt((String) jComboBoxDaxOutputNumber.getSelectedItem());

        Integer daxInOutDistance = Integer.parseInt((String) jComboBoxDaxInOutDistance.getSelectedItem());
        Integer goldInOutDistance = Integer.parseInt((String) jComboBoxGoldInOutDistance.getSelectedItem());
        Integer oilInOutDistance = Integer.parseInt((String) jComboBoxCrudeOilInOutDistance.getSelectedItem());

        System.out.println("DIST " + daxInOutDistance);

        dataSetCollection = new DataSetCollection();

        try {
            if (jCheckBoxDax.isSelected() && ((daxInputNumber > 0 && daxInputValuesIndicator.length > 0) || (daxOutputNumber > 0 && daxOutputValuesIndicator.length > 0))) {
                dataSetCollection.addDataSet(dax, daxInputNumber, daxInputValuesIndicator, daxOutputNumber, daxOutputValuesIndicator, daxInOutDistance);
            }
            if (jCheckBoxCrudeOil.isSelected() && ((oilInputNumber > 0 && oilInputValuesIndicator.length > 0) || (oilOutputNumber > 0 && oilOutputValuesIndicator.length > 0))) {
                dataSetCollection.addDataSet(oil, oilInputNumber, oilInputValuesIndicator, oilOutputNumber, oilOutputValuesIndicator, goldInOutDistance);
            }
            if (jCheckBoxGold.isSelected() && ((goldInputNumber > 0 && goldInputValuesIndicator.length > 0) || (goldOutputNumber > 0 && goldOutputValuesIndicator.length > 0))) {
                dataSetCollection.addDataSet(gold, goldInputNumber, goldInputValuesIndicator, goldOutputNumber, goldOutputValuesIndicator, oilInOutDistance);
            }

            for (MyDataSet dataSet : dataSetCollection.dataSets) {
                System.out.println(dataSet);
            }

            setLabelsButtonsAfterDataSetCreation();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonCreateDataSetCollectionMouseClicked

    private void jComboBoxDaxInputNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDaxInputNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDaxInputNumberActionPerformed

    private void jComboBoxTestingStartElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTestingStartElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTestingStartElementActionPerformed

    private void jComboBoxLearningElementsAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLearningElementsAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLearningElementsAmountActionPerformed

    private void jComboBoxTestingElementsAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTestingElementsAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTestingElementsAmountActionPerformed

    private void jComboBoxLearningStartElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLearningStartElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLearningStartElementActionPerformed

    private void jButtonPrepareLearningSetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPrepareLearningSetMouseClicked

        dataSetCollection.normalizeSimple();

        int trainingElementAmount = Integer.parseInt((String) jComboBoxLearningElementsAmount.getSelectedItem());
        String startingDate = (String) jComboBoxLearningStartElement.getSelectedItem();

        try {
            
            trainingData.prepareLearningSet(dataSetCollection, trainingElementAmount, startingDate);     
            setLabelsButtonsAfterPreparingLearningSet();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonPrepareLearningSetMouseClicked

    private void jButtonPrepareTestingSetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPrepareTestingSetMouseClicked

        dataSetCollection.normalizeSimple();

        int trainingElementAmount = Integer.parseInt((String) jComboBoxTestingElementsAmount.getSelectedItem());
        String startingDate = (String) jComboBoxTestingStartElement.getSelectedItem();
        try {
            trainingData.prepareTestingSet(dataSetCollection, trainingElementAmount, startingDate);
            setLabelsButtonsAfterPreparingTestingSet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonPrepareTestingSetMouseClicked

    private void jButtonCreateNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateNetworkMouseClicked
        Integer nodeInput = 0;
        Integer nodeOutput = 0;
        for (MyDataSet ds : dataSetCollection.dataSets) {
            nodeInput += ds.dataInputNumber * ds.dataInputValuesNumber;
            nodeOutput += ds.dataOutputNumber * ds.dataOutputValuesNumber;
        }
        System.out.println("IN OUT: " + nodeInput + "  " + nodeOutput);

        String[] nodesInner = jTextFieldLayers.getText().split(",");
        int[] layers = new int[nodesInner.length + 2];
        layers[0] = nodeInput;
        layers[layers.length - 1] = nodeOutput;
        for (int i = 0; i < nodesInner.length; i++) {
            layers[i + 1] = Integer.parseInt(nodesInner[i]);
        }

        System.out.println("Layers ");
        for (int i = 0; i < layers.length; i++) {
            System.out.print(layers[i] + " ");
        }

        Double maxError = Double.parseDouble(jTextFieldMaxError.getText());
        Double learningRate = Double.parseDouble(jTextFieldLearningRate.getText());
        Integer maxIterations = Integer.parseInt(jTextFieldMaxIterations.getText());

        network = new MultiLayerPerceptron(TransferFunctionType.LOG, layers);
        network.getLearningRule().setMaxError(maxError);
        network.getLearningRule().setMaxIterations(maxIterations);
        network.getLearningRule().setLearningRate(learningRate);

        setLabelsButtonsAfterNetworkCreation();
    }//GEN-LAST:event_jButtonCreateNetworkMouseClicked

    private void jButtonLearnNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLearnNetworkMouseClicked
        network.learn(trainingData.learningSet);
        setLabelsButtonsAfterNetworkLearning();
        
    }//GEN-LAST:event_jButtonLearnNetworkMouseClicked

    private void jButtonPrepareLearningSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrepareLearningSetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPrepareLearningSetActionPerformed

    private void jButtonTestNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTestNetworkMouseClicked

        result = new double[trainingData.testingSet.size()][trainingData.learningSet.getOutputSize()];
        System.out.println();
        System.out.println("Result " + result.length);
        System.out.println("Result[] " + result[0].length);
        DataSetRow dataRow;
        for (int i = 0; i < trainingData.testingSet.size(); i++) {
            dataRow = trainingData.testingSet.getRowAt(i);
            System.out.println("\n");
            System.out.println("First data for test " + dataRow.toString());
            network.setInput(dataRow.getInput());
            network.calculate();
            result[i] = network.getOutput().clone();

            System.out.print("Resul rows ");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }

        }
        System.out.println();

        dataSetCollection.backNormalizationInResultSimple(result);
        dataSetCollection.backNormalizationSimple();
        int trainingElementAmount = Integer.parseInt((String) jComboBoxLearningElementsAmount.getSelectedItem());
        String fileName = jTextFieldTestFileName.getText();
        fileName+=".txt";
        
        try {
            dataFileHandler.saveDataSetCollectinForTest(dataSetCollection, trainingData.testingSet.size(), trainingData.testingStartDate, result, fileName);
            setLabelsButtonsAfterNetworkTesting();
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTestNetworkMouseClicked

    private void jTextFieldTestFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTestFileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTestFileNameActionPerformed

    private void jButtonCreateNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateNetworkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCreateNetworkActionPerformed

    private void jButtonLoadNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoadNetworkMouseClicked
        String fileName = jTextFieldLoadNetworkFile.getText();
        network = (MultiLayerPerceptron) NeuralNetwork.createFromFile(fileName);
        setLabelsButtonsAfterNetworkLoading();
    }//GEN-LAST:event_jButtonLoadNetworkMouseClicked

    private void jButtonSaveNetworkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveNetworkMouseClicked
        String fileName = jTextFieldSaveNetworkFile.getText();
        network.save(fileName);
        setLabelsButtonsAfterNetworkSaving();
    }//GEN-LAST:event_jButtonSaveNetworkMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateDataSetCollection;
    private javax.swing.JButton jButtonCreateNetwork;
    private javax.swing.JButton jButtonLearnNetwork;
    private javax.swing.JButton jButtonLoadNetwork;
    private javax.swing.JButton jButtonPrepareLearningSet;
    private javax.swing.JButton jButtonPrepareTestingSet;
    private javax.swing.JButton jButtonSaveNetwork;
    private javax.swing.JButton jButtonTestNetwork;
    private javax.swing.JCheckBox jCheckBoxCrudeOil;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputAdjacent;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputClose;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputHigh;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputLow;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputOpen;
    private javax.swing.JCheckBox jCheckBoxCrudeOilInputVolumen;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputAdjacent;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputClose;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputHigh;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputLow;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputOpen;
    private javax.swing.JCheckBox jCheckBoxCrudeOilOutputVolumen;
    private javax.swing.JCheckBox jCheckBoxDax;
    private javax.swing.JCheckBox jCheckBoxDaxInputAdjacent;
    private javax.swing.JCheckBox jCheckBoxDaxInputClose;
    private javax.swing.JCheckBox jCheckBoxDaxInputHigh;
    private javax.swing.JCheckBox jCheckBoxDaxInputLow;
    private javax.swing.JCheckBox jCheckBoxDaxInputOpen;
    private javax.swing.JCheckBox jCheckBoxDaxInputVolumen;
    private javax.swing.JCheckBox jCheckBoxDaxOutputAdjacent;
    private javax.swing.JCheckBox jCheckBoxDaxOutputClose;
    private javax.swing.JCheckBox jCheckBoxDaxOutputHigh;
    private javax.swing.JCheckBox jCheckBoxDaxOutputLow;
    private javax.swing.JCheckBox jCheckBoxDaxOutputOpen;
    private javax.swing.JCheckBox jCheckBoxDaxOutputVolumen;
    private javax.swing.JCheckBox jCheckBoxGold;
    private javax.swing.JCheckBox jCheckBoxGoldInputAdjacent;
    private javax.swing.JCheckBox jCheckBoxGoldInputClose;
    private javax.swing.JCheckBox jCheckBoxGoldInputHigh;
    private javax.swing.JCheckBox jCheckBoxGoldInputLow;
    private javax.swing.JCheckBox jCheckBoxGoldInputOpen;
    private javax.swing.JCheckBox jCheckBoxGoldInputVolumen;
    private javax.swing.JCheckBox jCheckBoxGoldOutputAdjacent;
    private javax.swing.JCheckBox jCheckBoxGoldOutputClose;
    private javax.swing.JCheckBox jCheckBoxGoldOutputHigh;
    private javax.swing.JCheckBox jCheckBoxGoldOutputLow;
    private javax.swing.JCheckBox jCheckBoxGoldOutputOpen;
    private javax.swing.JCheckBox jCheckBoxGoldOutputVolumen;
    private javax.swing.JComboBox<String> jComboBoxCrudeOilInOutDistance;
    private javax.swing.JComboBox<String> jComboBoxCrudeOilInputNumber;
    private javax.swing.JComboBox<String> jComboBoxCrudeOilOutputNumber;
    private javax.swing.JComboBox<String> jComboBoxDaxInOutDistance;
    private javax.swing.JComboBox<String> jComboBoxDaxInputNumber;
    private javax.swing.JComboBox<String> jComboBoxDaxOutputNumber;
    private javax.swing.JComboBox<String> jComboBoxGoldInOutDistance;
    private javax.swing.JComboBox<String> jComboBoxGoldInputNumber;
    private javax.swing.JComboBox<String> jComboBoxGoldOutputNumber;
    private javax.swing.JComboBox<String> jComboBoxLearningElementsAmount;
    private javax.swing.JComboBox<String> jComboBoxLearningStartElement;
    private javax.swing.JComboBox<String> jComboBoxTestingElementsAmount;
    private javax.swing.JComboBox<String> jComboBoxTestingStartElement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCreateDataSetCollection;
    private javax.swing.JLabel jLabelCreateNetwork;
    private javax.swing.JLabel jLabelLearnNetwork;
    private javax.swing.JLabel jLabelLoadNetwork;
    private javax.swing.JLabel jLabelPrepareLearningSet;
    private javax.swing.JLabel jLabelPrepareTestingSet;
    private javax.swing.JLabel jLabelSaveNetwork;
    private javax.swing.JLabel jLabelTestNetwork;
    private javax.swing.JTextField jTextFieldLayers;
    private javax.swing.JTextField jTextFieldLearningRate;
    private javax.swing.JTextField jTextFieldLoadNetworkFile;
    private javax.swing.JTextField jTextFieldMaxError;
    private javax.swing.JTextField jTextFieldMaxIterations;
    private javax.swing.JTextField jTextFieldSaveNetworkFile;
    private javax.swing.JTextField jTextFieldTestFileName;
    // End of variables declaration//GEN-END:variables
}
