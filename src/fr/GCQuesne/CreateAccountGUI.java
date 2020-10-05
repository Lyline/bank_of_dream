package fr.GCQuesne;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CreateAccountGUI {
  JPanel mainPanel;
  JPanel idPanel;
  JTextField textField1;
  JTextField textField2;
  JPanel typeAccountPanel;
  JCheckBox currentTypeCheckBox;
  JCheckBox savingTypeCheckBox;
  JTextArea textArea1;
  JButton ValidateBtn;
  JCheckBox joinTypeCheckBox;
  JLabel balanceInitialLabel;
  JLabel euroLabel;
  JLabel imgBackgroundAccount;

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR call it in your
   * code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
    mainPanel.setBackground(new Color(-3100784));
    mainPanel.setPreferredSize(new Dimension(450, 500));
    idPanel = new JPanel();
    idPanel.setLayout(new GridBagLayout());
    idPanel.setBackground(new Color(-3100784));
    mainPanel.add(idPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(300, 150), null, 0, false));
    idPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Identification", TitledBorder.LEADING, TitledBorder.TOP, this.$$$getFont$$$("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 16, idPanel.getFont()), new Color(-14342875)));
    final JLabel label1 = new JLabel();
    label1.setForeground(new Color(-14342875));
    label1.setHorizontalAlignment(2);
    label1.setText("Nom :");
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    idPanel.add(label1, gbc);
    final JLabel label2 = new JLabel();
    label2.setForeground(new Color(-14342875));
    label2.setHorizontalAlignment(2);
    label2.setText("Prénom :");
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.VERTICAL;
    idPanel.add(label2, gbc);
    textField2 = new JTextField();
    textField2.setBackground(new Color(-5468041));
    textField2.setMinimumSize(new Dimension(200, 30));
    textField2.setPreferredSize(new Dimension(200, 30));
    textField2.setText("");
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(25, 15, 25, 0);
    idPanel.add(textField2, gbc);
    textField1 = new JTextField();
    textField1.setBackground(new Color(-5468041));
    textField1.setMinimumSize(new Dimension(200, 30));
    textField1.setPreferredSize(new Dimension(200, 30));
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(25, 15, 25, 0);
    idPanel.add(textField1, gbc);
    typeAccountPanel = new JPanel();
    typeAccountPanel.setLayout(new GridBagLayout());
    typeAccountPanel.setBackground(new Color(-3100784));
    typeAccountPanel.setForeground(new Color(-14342875));
    mainPanel.add(typeAccountPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 80), null, 0, false));
    typeAccountPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Compte n° : XXXXXX", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 16, typeAccountPanel.getFont()), new Color(-14342875)));
    currentTypeCheckBox = new JCheckBox();
    currentTypeCheckBox.setBackground(new Color(-3100784));
    currentTypeCheckBox.setForeground(new Color(-14342875));
    currentTypeCheckBox.setText("Compte Courant");
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(15, 0, 20, 0);
    typeAccountPanel.add(currentTypeCheckBox, gbc);
    savingTypeCheckBox = new JCheckBox();
    savingTypeCheckBox.setBackground(new Color(-3100784));
    savingTypeCheckBox.setForeground(new Color(-14342875));
    savingTypeCheckBox.setText("Compte Epargne");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(15, 20, 20, 20);
    typeAccountPanel.add(savingTypeCheckBox, gbc);
    balanceInitialLabel = new JLabel();
    balanceInitialLabel.setForeground(new Color(-14342875));
    balanceInitialLabel.setText("Solde :");
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(0, 0, 20, 15);
    typeAccountPanel.add(balanceInitialLabel, gbc);
    textArea1 = new JTextArea();
    textArea1.setBackground(new Color(-5468041));
    textArea1.setForeground(new Color(-14342875));
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(0, 0, 20, 0);
    typeAccountPanel.add(textArea1, gbc);
    joinTypeCheckBox = new JCheckBox();
    joinTypeCheckBox.setBackground(new Color(-3100784));
    joinTypeCheckBox.setForeground(new Color(-14342875));
    joinTypeCheckBox.setText("Compte Joint");
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(15, 0, 20, 0);
    typeAccountPanel.add(joinTypeCheckBox, gbc);
    ValidateBtn = new JButton();
    ValidateBtn.setBackground(new Color(-3100784));
    ValidateBtn.setForeground(new Color(-14342875));
    ValidateBtn.setText("Confirmer");
    gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0, 0, 20, 0);
    typeAccountPanel.add(ValidateBtn, gbc);
    euroLabel = new JLabel();
    euroLabel.setForeground(new Color(-14342875));
    euroLabel.setText("euros");
    gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(0, 15, 20, 0);
    typeAccountPanel.add(euroLabel, gbc);
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    panel1.setBackground(new Color(-3100784));
    mainPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    imgBackgroundAccount = new JLabel();
    imgBackgroundAccount.setBackground(new Color(-3100784));
    imgBackgroundAccount.setIcon(new ImageIcon(getClass().getResource("/img/create_account.png")));
    imgBackgroundAccount.setIconTextGap(0);
    imgBackgroundAccount.setInheritsPopupMenu(false);
    imgBackgroundAccount.setOpaque(false);
    imgBackgroundAccount.setText("");
    imgBackgroundAccount.setVerticalAlignment(1);
    imgBackgroundAccount.setVerticalTextPosition(1);
    panel1.add(imgBackgroundAccount, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(350, 300), new Dimension(450, 500), new Dimension(500, 300), 0, false));
  }

  /** @noinspection ALL */
  private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
    if (currentFont == null) return null;
    String resultName;
    if (fontName == null) {
      resultName = currentFont.getName();
    } else {
      Font testFont = new Font(fontName, Font.PLAIN, 10);
      if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
        resultName = fontName;
      } else {
        resultName = currentFont.getName();
      }
    }
    return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
  }

  /** @noinspection ALL */
  public JComponent $$$getRootComponent$$$() {
    return mainPanel;
  }
}
