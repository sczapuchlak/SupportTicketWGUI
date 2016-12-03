package com;
import sun.awt.image.ImageWatched;
import sun.security.krb5.internal.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;


public class ticketGUI extends JFrame{
    private JPanel rootPanel;
    private JButton addATicketButton;
    private JList currentTicketList;
    private JTextField pleaseEnterYourNameTextField;
    private JTextField reportYourIssueTextField;
    private JComboBox priorityComboBox;
    private JButton showAllTicketsButton;
    private JButton exitProgramButton;
    private JButton resolvedTicketsButton;
    private DefaultListModel<ticket> listModel;
    
    // create all the scanners and lists to hold the open files
    Scanner fileScanner = new Scanner(System.in);
    BufferedWriter fileWriter = new BufferedWriter(new FileWriter("open_tickets.txt", true));
    static LinkedList<ticket> ticketsInQueue = new LinkedList<>();
    LinkedList<ticket> resolvedTickets = new LinkedList<>();
    Scanner incomingFile = new Scanner(new File("open_tickets.txt"));
    String dateFormat = "EEE MMM dd hh:mm:ss z yyyy";
    SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);








    public ticketGUI()throws Exception{

        //set up all the parts of the gui to make it run and visible
        super("Ticket Handling Program");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500,500));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        listModel = new DefaultListModel<ticket>();
        currentTicketList.setModel(listModel);
        //When the program is opened , the lists shows open tickets
        for (ticket tickyyyy : ticketsInQueue){
            listModel.addElement(tickyyyy);
            priorityComboBox.addItem((tickyyyy.getTicketID()));
        }

        //add a loop to run through all the old tickets and open tickets from the file
        openFiles();


        //create ticket object from the text that was opened.
        while (incomingFile.hasNext()) {ticket openTicket = new ticket(incomingFile.nextLine(), Integer.parseInt(incomingFile.nextLine()),
                    incomingFile.nextLine(), dateFormatter.parse(incomingFile.nextLine()));
            ticketsInQueue.add(openTicket);
        }
        showAllTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();;
                for (ticket ticky : ticketsInQueue){
                    listModel.addElement(ticky);
                }
            }
        });
        exitProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

        //show all the open tickets in the Jlist

    public void addListeners(){
        //Adds tickets to ticketQueue. Also adds the new ticket from the user to the new JList.
        addATicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newIssue = reportYourIssueTextField.getText();
                int newPriority =(Integer) priorityComboBox.getSelectedItem();
                String enterYourName = pleaseEnterYourNameTextField.getText();
               Date newDateAdded =new Date();
                ticket tickky =new ticket(newIssue,newPriority,enterYourName,newDateAdded);
                listModel.addElement(tickky);
            }
        });


    // Displays all the resolved tickets
        resolvedTicketsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            listModel.clear();
            for (ticket tickky : resolvedTickets) {
                listModel.addElement(tickky);
            }
        }
    });}

    //open files
    public static void openFiles(){
        Scanner newScannerForWordsInFile;
        String wordLookingForInTicket;
        //use try and catch and create variable to store the datat found on open ticket files
        try {
            newScannerForWordsInFile = new Scanner(new FileReader(("open_tickets.txt")));
            newScannerForWordsInFile.useDelimiter(" ");


        } catch (IOException e){
            System.out.println("The File Could Not be Saved! Try Again!");
        }}


    public static void saveAFile() {
        //use a try block to catch any errors with writing to  the file (reg tickets, not resolved ones)
        try {
            FileWriter writer = new FileWriter("open_tickets.txt");
            for (ticket ticketFound : ticketsInQueue) {
                writer.write(String.valueOf(ticketFound + "\n"));
            }
            //close the writer
            writer.close();
        } catch (IOException e) {
            System.out.println("File was not found! Please try again!");

        }
    }

        //use a try block to catch any errors with writing to the resolved save files
       /* public static void resolvedFileSave(){
        try{
            Date dateResolved = new Date();
            String ticketsClosed = ("Tickets have been resolved on: "+dateResolved+"resolved_tickets.txt");
            BufferedWriter closerWriter = new BufferedWriter((new FileWriter(ticketsClosed)));
            // /for loop like above
            for ((ticket ticketFound :){
                resolvedWriter.write(String.valueOf(ticketFound + '\n'));
            }
            //close writer
            resolvedWriter.close();
            }catch(IOException e){
            System.out.println("The file could not be saved. Please try again!");


        }}


    */}
