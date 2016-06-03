/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przemek.BIAI.projekt.neuroph;

import java.util.ArrayList;

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

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        dataFileHandler.loadData("DAX300.txt", dax);
        dataFileHandler.loadData("CrudeOil300.txt", oil);
        dataFileHandler.loadData("Gold300.txt", gold);
        
        for (Integer i = 0; i < 100; i++) {
            jComboBoxCrudeOilInputNumber.addItem(i.toString());
            jComboBoxDaxInputNumber.addItem(i.toString());
            jComboBoxGoldInputNumber.addItem(i.toString());

            jComboBoxCrudeOilOutputNumber.addItem(i.toString());
            jComboBoxDaxOutputNumber.addItem(i.toString());
            jComboBoxGoldOutputNumber.addItem(i.toString());

        }
    }

    private ArrayList<Integer> getDaxInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);

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

        return inputValuesIndicator;
    }

    private ArrayList<Integer> getOilInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);

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

        return inputValuesIndicator;
    }

    private ArrayList<Integer> getGoldInputValuesIndicator() {
        ArrayList<Integer> inputValuesIndicator = new ArrayList<Integer>(0);

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

        return inputValuesIndicator;
    }

    private ArrayList<Integer> getDaxOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);

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

        return outputValuesIndicator;
    }

    private ArrayList<Integer> getOilOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);

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

        return outputValuesIndicator;
    }

    private ArrayList<Integer> getGoldOutputValuesIndicator() {
        ArrayList<Integer> outputValuesIndicator = new ArrayList<Integer>(0);

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

        return outputValuesIndicator;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jTextFieldInOutDistance = new javax.swing.JTextField();
        jButtonPrepareLearningSet = new javax.swing.JButton();
        jButtonPrepareTestingSet = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldLearningStartingElement = new javax.swing.JTextField();
        jTextFieldTestingStartingElement = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldLearningElementAmount = new javax.swing.JTextField();
        jTextFieldTestingElementAmount = new javax.swing.JTextField();
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
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jCheckBoxDaxInputAdjacent.setText("Adjacent");

        jCheckBoxDaxInputVolumen.setText("Volumen");

        jLabel1.setText("Input number");

        jLabel2.setText("Output number");

        jLabel3.setText("Input output distance");

        jLabel4.setText("Input");

        jLabel5.setText("Output");

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

        jCheckBoxDaxOutputAdjacent.setText("Adjacent");

        jCheckBoxDaxOutputVolumen.setText("Volumen");

        jCheckBoxCrudeOilOutputLow.setText("Low");

        jLabel6.setText("Input number");

        jCheckBoxCrudeOilOutputClose.setText("Close");

        jLabel7.setText("Output number");

        jCheckBoxCrudeOilOutputAdjacent.setText("Adjacent");

        jCheckBoxCrudeOilOutputVolumen.setText("Volumen");

        jLabel8.setText("Input");

        jLabel9.setText("Output");

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

        jCheckBoxCrudeOilInputAdjacent.setText("Adjacent");

        jCheckBoxCrudeOilOutputOpen.setText("Open");
        jCheckBoxCrudeOilOutputOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilOutputOpenActionPerformed(evt);
            }
        });

        jCheckBoxCrudeOilInputVolumen.setText("Volumen");

        jCheckBoxCrudeOilOutputHigh.setText("High");
        jCheckBoxCrudeOilOutputHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCrudeOilOutputHighActionPerformed(evt);
            }
        });

        jCheckBoxGoldOutputLow.setText("Low");

        jCheckBoxGoldOutputClose.setText("Close");

        jCheckBoxGoldOutputAdjacent.setText("Adjacent");

        jCheckBoxGoldOutputVolumen.setText("Volumen");

        jCheckBoxGoldInputVolumen.setText("Volumen");

        jLabel10.setText("Input number");

        jLabel11.setText("Output number");

        jLabel12.setText("Input");

        jLabel13.setText("Output");

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

        jCheckBoxGoldInputAdjacent.setText("Adjacent");

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

        jCheckBoxDax.setText("DAX");

        jCheckBoxCrudeOil.setText("Crude Oil");

        jCheckBoxGold.setText("Gold");

        jTextFieldInOutDistance.setText("In Out distance");

        jButtonPrepareLearningSet.setText("Prepare learning set");

        jButtonPrepareTestingSet.setText("Prepare testing set");

        jLabel14.setText("Learning starting element ");

        jLabel15.setText("Testing starting element");

        jTextFieldLearningStartingElement.setText("Learning start");
        jTextFieldLearningStartingElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLearningStartingElementActionPerformed(evt);
            }
        });

        jTextFieldTestingStartingElement.setText("Testing start");

        jLabel16.setText("Learning elements amount");

        jLabel17.setText("Testing elements amount");

        jTextFieldLearningElementAmount.setText("learnign elements");
        jTextFieldLearningElementAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLearningElementAmountActionPerformed(evt);
            }
        });

        jTextFieldTestingElementAmount.setText("testing elements");
        jTextFieldTestingElementAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTestingElementAmountActionPerformed(evt);
            }
        });

        jLabel18.setText("Learning rate");

        jLabel19.setText("Max error");

        jLabel20.setText("Max iterations");

        jLabel21.setText("Layers");

        jTextFieldMaxIterations.setText("Iterations");

        jTextFieldLearningRate.setText("Learning rate");

        jTextFieldMaxError.setText("Max error");

        jTextFieldLayers.setText("Layers");

        jComboBoxDaxInputNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDaxInputNumberActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

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
                                    .add(jComboBoxDaxOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jCheckBoxDax))
                        .add(85, 85, 85)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel8)
                                        .add(60, 60, 60)
                                        .add(jLabel9))
                                    .add(jCheckBoxCrudeOil))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 228, Short.MAX_VALUE)
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
                                            .add(layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(jCheckBoxGoldOutputClose)
                                                    .add(jCheckBoxGoldOutputAdjacent)
                                                    .add(jCheckBoxGoldOutputVolumen)
                                                    .add(jCheckBoxGoldOutputOpen)
                                                    .add(jCheckBoxGoldOutputHigh)
                                                    .add(jCheckBoxGoldOutputLow))
                                                .add(34, 34, 34)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(jLabel11)
                                                    .add(jLabel10)
                                                    .add(jComboBoxGoldOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                    .add(jComboBoxGoldInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                            .add(jLabel13)))
                                    .add(jCheckBoxGold))
                                .add(66, 66, 66))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jCheckBoxCrudeOilInputClose)
                                            .add(jCheckBoxCrudeOilInputVolumen)
                                            .add(jCheckBoxCrudeOilInputOpen)
                                            .add(jCheckBoxCrudeOilInputHigh)
                                            .add(jCheckBoxCrudeOilInputLow))
                                        .add(22, 22, 22))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(jCheckBoxCrudeOilInputAdjacent)
                                        .add(18, 18, 18)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jCheckBoxCrudeOilOutputClose)
                                    .add(jCheckBoxCrudeOilOutputAdjacent)
                                    .add(jCheckBoxCrudeOilOutputOpen)
                                    .add(jCheckBoxCrudeOilOutputHigh)
                                    .add(jCheckBoxCrudeOilOutputLow)
                                    .add(jCheckBoxCrudeOilOutputVolumen))
                                .add(34, 34, 34)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel7)
                                    .add(jLabel6)
                                    .add(jComboBoxCrudeOilOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jComboBoxCrudeOilInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(20, 20, 20))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jButtonCreateDataSetCollection)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(18, 18, 18)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(jTextFieldInOutDistance)
                                            .add(jTextFieldLearningStartingElement)
                                            .add(jTextFieldTestingStartingElement))))
                                .add(51, 51, 51)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel17)
                                        .add(10, 10, 10)
                                        .add(jTextFieldTestingElementAmount))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel16)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextFieldLearningElementAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(47, 47, 47)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(jLabel19)
                                                    .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(35, 35, 35))
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel18)
                                                .add(22, 22, 22)))
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(jTextFieldLearningRate)
                                            .add(jTextFieldMaxError)
                                            .add(jTextFieldLayers)))
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextFieldMaxIterations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(jButtonPrepareLearningSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jButtonPrepareTestingSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(316, Short.MAX_VALUE))))
            .add(layout.createSequentialGroup()
                .add(268, 268, 268)
                .add(jRadioButton1)
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jRadioButton1)
                .add(25, 25, 25)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jCheckBoxDax)
                    .add(jCheckBoxCrudeOil)
                    .add(jCheckBoxGold))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel8)
                                .add(jLabel9))
                            .add(18, 18, 18)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxCrudeOilInputOpen)
                                        .add(jLabel6))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(jComboBoxCrudeOilInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(14, 14, 14)
                                            .add(jLabel7)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jComboBoxCrudeOilOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(layout.createSequentialGroup()
                                            .add(jCheckBoxCrudeOilInputHigh)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxCrudeOilInputLow)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxCrudeOilInputClose)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jCheckBoxCrudeOilInputVolumen)
                                                .add(jCheckBoxCrudeOilOutputVolumen)))))
                                .add(layout.createSequentialGroup()
                                    .add(jCheckBoxCrudeOilOutputOpen)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxCrudeOilOutputHigh)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxCrudeOilOutputLow)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxCrudeOilOutputClose)
                                    .add(29, 29, 29)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxCrudeOilOutputAdjacent)
                                        .add(jCheckBoxCrudeOilInputAdjacent)))))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel12)
                                .add(jLabel13))
                            .add(18, 18, 18)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout.createSequentialGroup()
                                    .add(jCheckBoxGoldOutputOpen)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldOutputHigh)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldOutputLow)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jCheckBoxGoldOutputClose)
                                    .add(29, 29, 29)
                                    .add(jCheckBoxGoldOutputAdjacent))
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jCheckBoxGoldInputOpen)
                                        .add(jLabel10))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(7, 7, 7)
                                            .add(jComboBoxGoldInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(jLabel11)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(jComboBoxGoldOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(layout.createSequentialGroup()
                                            .add(jCheckBoxGoldInputHigh)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxGoldInputLow)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jCheckBoxGoldInputClose)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jCheckBoxGoldInputVolumen)
                                                .add(jCheckBoxGoldOutputVolumen))))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jCheckBoxGoldInputAdjacent)))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(jLabel5))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jCheckBoxDaxInputOpen)
                                    .add(jLabel1))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jCheckBoxDaxInputHigh)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jCheckBoxDaxInputLow)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jCheckBoxDaxInputClose))
                                    .add(layout.createSequentialGroup()
                                        .add(7, 7, 7)
                                        .add(jComboBoxDaxInputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jLabel2)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jComboBoxDaxOutputNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
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
                                    .add(jCheckBoxDaxOutputAdjacent))))))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jTextFieldInOutDistance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel14)
                                    .add(jTextFieldLearningStartingElement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel15)
                                    .add(jTextFieldTestingStartingElement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(32, 32, 32)
                                .add(jButtonCreateDataSetCollection))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jTextFieldMaxIterations, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
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
                                    .add(jTextFieldLayers, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(layout.createSequentialGroup()
                        .add(61, 61, 61)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel16)
                            .add(jTextFieldLearningElementAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel17)
                            .add(jTextFieldTestingElementAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonPrepareLearningSet)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButtonPrepareTestingSet)
                .addContainerGap(94, Short.MAX_VALUE))
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

    private void jTextFieldLearningStartingElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLearningStartingElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLearningStartingElementActionPerformed

    private void jTextFieldLearningElementAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLearningElementAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLearningElementAmountActionPerformed

    private void jTextFieldTestingElementAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTestingElementAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTestingElementAmountActionPerformed

    private void jButtonCreateDataSetCollectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCreateDataSetCollectionMouseClicked

        ArrayList<Integer> daxInputValuesIndicator = getDaxInputValuesIndicator();
        ArrayList<Integer> goldInputValuesIndicator = getGoldInputValuesIndicator();
        ArrayList<Integer> oilInputValuesIndicator = getOilInputValuesIndicator();

        ArrayList<Integer> daxOutputValuesIndicator = getDaxOutputValuesIndicator();
        ArrayList<Integer> goldOutputValuesIndicator = getGoldOutputValuesIndicator();
        ArrayList<Integer> oilOutputValuesIndicator = getOilOutputValuesIndicator();

        Integer oilInputNumber = (Integer) jComboBoxCrudeOilInputNumber.getSelectedItem();
        Integer goldInputNumber = (Integer) jComboBoxGoldInputNumber.getSelectedItem();
        Integer daxInputNumber = (Integer) jComboBoxDaxInputNumber.getSelectedItem();

        Integer oilOutputNumber = (Integer) jComboBoxCrudeOilOutputNumber.getSelectedItem();
        Integer goldOutputNumber = (Integer) jComboBoxGoldOutputNumber.getSelectedItem();
        Integer daxOutputNumber = (Integer) jComboBoxDaxOutputNumber.getSelectedItem();

        if(jCheckBoxDax.isSelected()){
            dataSetCollection.addDataSet(dax,daxInputNumber,(Integer[])daxInputValuesIndicator.toArray(),daxOutputNumber,(Integer[])daxOutputValuesIndicator.toArray(),2);
        }
        if(jCheckBoxCrudeOil.isSelected()){
             dataSetCollection.addDataSet(oil,oilInputNumber,(Integer[])oilInputValuesIndicator.toArray(),oilOutputNumber,(Integer[])oilOutputValuesIndicator.toArray(),2);
        }
        if(jCheckBoxGold.isSelected()){
            
        }
        dataSetCollection.addDataSet

    }//GEN-LAST:event_jButtonCreateDataSetCollectionMouseClicked

    private void jComboBoxDaxInputNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDaxInputNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDaxInputNumberActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCreateDataSetCollection;
    private javax.swing.JButton jButtonPrepareLearningSet;
    private javax.swing.JButton jButtonPrepareTestingSet;
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
    private javax.swing.JComboBox<String> jComboBoxCrudeOilInputNumber;
    private javax.swing.JComboBox<String> jComboBoxCrudeOilOutputNumber;
    private javax.swing.JComboBox<String> jComboBoxDaxInputNumber;
    private javax.swing.JComboBox<String> jComboBoxDaxOutputNumber;
    private javax.swing.JComboBox<String> jComboBoxGoldInputNumber;
    private javax.swing.JComboBox<String> jComboBoxGoldOutputNumber;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextFieldInOutDistance;
    private javax.swing.JTextField jTextFieldLayers;
    private javax.swing.JTextField jTextFieldLearningElementAmount;
    private javax.swing.JTextField jTextFieldLearningRate;
    private javax.swing.JTextField jTextFieldLearningStartingElement;
    private javax.swing.JTextField jTextFieldMaxError;
    private javax.swing.JTextField jTextFieldMaxIterations;
    private javax.swing.JTextField jTextFieldTestingElementAmount;
    private javax.swing.JTextField jTextFieldTestingStartingElement;
    // End of variables declaration//GEN-END:variables
}
