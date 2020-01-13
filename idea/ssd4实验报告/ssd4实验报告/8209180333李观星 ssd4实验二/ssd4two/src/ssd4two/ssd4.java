package ssd4two;

import javax.swing.text.Document;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ssd4 extends javax.swing.JFrame implements DocumentListener {
    @Override
    public void insertUpdate(DocumentEvent e) {
        jTextArea1.setText("");
        jTextField2.setText("");
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }


    @Override
    public void removeUpdate(DocumentEvent e) {
        jTextArea1.setText("");
        jTextField2.setText("");
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }


    @Override
    public void changedUpdate(DocumentEvent e) {
        jTextArea1.setText("");
        jTextField2.setText("");
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }

    public ssd4() {
        initComponents();
        this.setTitle("UAR Components");
        this.jTextField1.requestFocus();
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 510));

        jPanel1.setPreferredSize(new java.awt.Dimension(705, 305));
        jPanel1.setRequestFocusEnabled(false);

        jButton3.setText("Exit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel14.setText("jLabel14");

        jLabel13.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel13.setText("jLabel13");

        jButton2.setText("Search");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Display");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel10.setText("Enter a number:");

        jLabel11.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel11.setText("Enter a search string:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField2PropertyChange(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel12.setText("Found at:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel7.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel7.setText("7. Relationship to Other Usability Aspects");

        jLabel6.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel6.setText("6. Possible Solutions and Potential Trade-offs");

        jLabel5.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel5.setText("5. Severity of the Problem or Benefit of the Good Feature");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel4.setText("4. Explanation of the Aspect");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel3.setText("3. Evidence for the Aspect");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel2.setText("2. Succinct Description of the Usability Aspect");

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel1.setText("1. UAR Identitier");

        jLabel8.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        jLabel8.setText("UAR components names:");

        jLabel9.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        jLabel9.setText("UAR component description:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(jLabel10)
                                                                .addGap(64, 64, 64))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel11)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel14))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12))))
                                .addContainerGap(70, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jLabel10)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(jButton2)
                                        .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            Integer.parseInt(jTextField1.getText());
        } catch (Exception e) {
            // 不是int
            JOptionPane.showMessageDialog(null, "Please enter value between 1 and 7", "Search String", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            jTextField1.selectAll();
        }
        int number = Integer.parseInt(jTextField1.getText());
        switch (number) {
            case 1: {
                jTextArea1.setText("This should be a unique identifier for the purposes of filing. If more than one person is working on the project or more than one analysis technique is being used, this identifier could contain letters and numbers. For example, if Chris Smith and Jan Koo are both doing an analysis, the identifier might be CS1 or JK75. If both a heuristic evaluation and a think-aloud usability study were used, the identifiers might be HE6 or TA89. Follow the unique identifier with the word 'Problem,' if the report pertains to a usability problem of the interface, or the words 'Good Feature,' if it describes an aspect of the interface you feel should be preserved in any redesign.");
                jTextField2.requestFocus();
                break;
            }
            case 2: {
                jTextArea1.setText("This description will be used as the 'name' of this UAR when you talk about its relation to other UARs. Make the name as short as possible (about three to five words) but still descriptive and distinguishable from other aspects of the system. If this UAR is about a problem (as opposed to a good feature), make sure you have a name that describes the problem, rather than a solution.");
                jTextField2.requestFocus();
                break;
            }
            case 3: {
                jTextArea1.setText("This is the objective supporting material that justifies your identifying the aspect as worthy of report. This section needs to contain enough information for a reader of this UAR to understand what triggered the report. For an HE report, for instance, this could be an image of a cluttered screen and the heuristic about aesthetics and minimalist design. In a think-aloud study this is usually what was on the screen (a screen shot or description), what the user did (keystrokes, mouse movements), what the system did in response to any user actions, and what the user said. You need to include enough pertinent information about the identification of an aspect for the reader to understand what the analyst was thinking when the aspect was identified (for HE) or what the user was trying to do when the aspect either hindered or facilitated his or her progress.");
                jTextField2.requestFocus();
                break;
            }
            case 4: {
                jTextArea1.setText("This is your interpretation of the evidence. That is, for a think-aloud usability test, why you think what happened happened, or, for an HE, why you think the aspect was designed the way it was. You need to provide enough content in this explanation for the reader to understand the problem-even if they do not know the system or domain as well as you do.");
                jTextField2.requestFocus();
                break;
            }
            case 5: {
                jTextArea1.setText("This is your reasoning about how important it is to either fix this problem or preserve this good feature. This includes how frequently the users will experience this aspect, whether they are likely to learn how it works, whether it will affect new users, casual users, experienced users, etc.");
                jTextField2.requestFocus();
                break;
            }
            case 6: {
                jTextArea1.setText("If this aspect is a problem (as opposed to a good feature to be preserved in the next version of the software), this is the place to propose a solution. It is not necessary to have a solution as soon as you identify a problem-you might find after analyzing the whole interface that many problems are related and can all be fixed by making a single broad change instead of making several small changes. However, if you do propose a possible solution, report any potential design trade-offs that you see");
                jTextField2.requestFocus();
                break;
            }
            case 7: {
                jTextArea1.setText("It is often the case that UARs are related to each other. This is where you record which UARs this one is related to and a statement about how it is related. Make sure that all the related UARs point to each other. It is a common mistake to enter the pointer into a newly created UAR, but neglect to go back to the previous ones that it relates to and update their UARs.");
                jTextField2.requestFocus();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "Please enter value between 1 and 7", "Search String", JOptionPane.WARNING_MESSAGE);
                jTextField1.requestFocus();
                jTextField1.selectAll();
                break;
            }
        }
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        System.exit(WIDTH);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (jTextArea1.getText().length() == 0 || jTextField1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please select text", "Search String", JOptionPane.WARNING_MESSAGE);
            jButton1.requestFocus();
        } else if (jTextField2.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a search String", "Search String", JOptionPane.WARNING_MESSAGE);
            jTextField2.requestFocus();
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
        } else {
            String _sourse = jTextArea1.getText().toLowerCase();
            String _search = jTextField2.getText().toLowerCase();
            int total = 0;
            int first, last;
            first = 0;
            last = 0;
            int countLoop = 0;
            for (String temp = _sourse; temp != null && temp.length() >= _search.length(); ) {
                if (temp.indexOf(_search) == 0) {
                    countLoop += _search.length();
                    total++;
                    if (total == 1) {
                        first = countLoop - _search.length() + 1;
                    }
                    last = countLoop - _search.length() + 1;
                    temp = _sourse.substring(countLoop);
                } else {
                    countLoop += 1;
                    temp = _sourse.substring(countLoop);
                }
            }

            Object[] options = {"是（Y）", "否（N）"};
            if (total == 0) {
                int response = JOptionPane.showOptionDialog(this, "String '" + _search + "' not found " + total + "\nSearch same text again?",
                        "Search String", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (response == 0) {
                    jTextField2.requestFocus();
                    jTextField2.selectAll();
                    jLabel13.setVisible(false);
                    jLabel14.setVisible(false);
                }
                if (response == 1) {
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextArea1.setText("");
                    jLabel13.setVisible(false);
                    jLabel14.setVisible(false);
                    jTextField1.requestFocus();
                }
            } else {
                int response = JOptionPane.showOptionDialog(this, "The number of occurences of '" + _search + "' is: " + total + "\nSearch same text?",
                        "Search String", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (response == 0) {
                    jTextField2.requestFocus();
                    jTextField2.selectAll();
                    if (total == 1) {
                        jLabel13.setVisible(true);
                        jLabel13.setText("Occurrence 1: Position: " + first);
                    } else {
                        jLabel13.setVisible(true);
                        jLabel14.setVisible(true);
                        jLabel13.setText("Occurrence 1: Position: " + first);
                        jLabel14.setText("Occurrence " + total + ": Position: " + last);
                    }
                }
                if (response == 1) {
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextArea1.setText("");
                    jLabel13.setVisible(false);
                    jLabel14.setVisible(false);
                    jTextField1.requestFocus();
                }
            }

        }
    }

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
        Document doc = jTextField1.getDocument();
        //添加DocumentListener监听器
        doc.addDocumentListener(this);
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextField2.setText(null);
    }

    private void jTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO add your handling code here:
        if (jTextField2.isValid()) {
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
        }

    }


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
            java.util.logging.Logger.getLogger(ssd4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ssd4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ssd4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ssd4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ssd4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}