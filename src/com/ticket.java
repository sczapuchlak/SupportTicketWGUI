package com;

import java.util.Date;

public class ticket {
    //create private variables
    protected int ticketID;
    private Date resolvedDate;
    private String resolutionDesc;
    private ticket resolvedTicket;
    private int priority;
    private String personReported;
    private String description;
    private Date reportedDate;
    protected int ticketIDCounter=1; //so everyone gets a unique id number
    //initialize
    public ticket( String descrip,int priorityA1,String personRepor, Date dateReported ){
    this.ticketID = ticketIDCounter;
        ticketIDCounter++;
    this.description= descrip ;
    this.priority= priorityA1;
    this.personReported=personRepor;
    this.reportedDate = dateReported;

    }


    public int getTicketID() {
        return ticketID;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }


    public ticket getResolvedTicket() {
        return resolvedTicket;
    }

    public int getPriority() {
        return priority;
    }

    public String getPersonReported() {
        return personReported;
    }
    //make ticket into a string

    public String toString(){
        return( "The ticket ID is :"+this.ticketID+"described as "+this.description+ "that was marked as priority "
                +this.priority+ "reported on "+ this.reportedDate +"by "+this.personReported);}

    public String getDescription() {
        return description;
    }
    public String getResolutionDesc(){
        return resolutionDesc;
    }
    public Date getReportedDate(){
        return resolvedDate;
    }

    public void resolvedTicket(ticket resolvedTicket,Date resolvedDate,String resolutionDesc){
        this.resolvedTicket= resolvedTicket;
        this.resolvedDate= resolvedDate;
        this.resolutionDesc =resolutionDesc;}

    //add a to string method
    public String resolvedToString(){
        return ("The ticket ID is :"+this.ticketID+" that was issued on "+ this.resolvedDate+
        "that was marked as priority "+this.priority+ "reported on "+ resolvedTicket.getReportedDate()+"by "+
        resolvedTicket.getPersonReported()+ "was resolved on "+ this.resolvedDate+" because "+ this.resolutionDesc);
    }
    }

