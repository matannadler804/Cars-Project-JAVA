package Application;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Comparator;

public class TblQryBoats extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> tableSorter;

    public TblQryBoats() {
        ArrayList<Boat> boats = new ArrayList<>();
        boats.add(new Boat("1", "Boat1", "s1", true));
        boats.add(new Boat("2", "Boat2", "s2", true));
        boats.add(new Boat("5", "Boat5", "s5", true));
        boats.add(new Boat("3", "Boat3", "s3", true));
        boats.add(new Boat("3", "Boat3", "s3", true));
        boats.add(new Boat("2", "Boat2", "s2", true));
        boats.add(new Boat("2", "Boat2", "s2", true));

        String[] columnNames = {"ID", "Model", "Sub Model", "Is Electric"};
        Object[][] rowData = new Object[boats.size()][columnNames.length];

        // Populate the table data
        for (int i = 0; i < boats.size(); i++) {
            Boat boat = boats.get(i);
            rowData[i][0] = boat.getId();
            rowData[i][1] = boat.getModel();
            rowData[i][2] = boat.getSubModel();
            rowData[i][3] = boat.isElectric();
        }

        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // Enable column sorting
        tableSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableSorter);

        // Display the table
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TblQryBoats();
            }
        });
    }
}
