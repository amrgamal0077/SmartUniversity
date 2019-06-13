package com.example.momen.smart_university.firebase.Doctor;

public class Office_Hour {
     public boolean reserved;
     public String from;
     public String to;
     public String reservedFrom;

     public Office_Hour() {

     }
     public  Office_Hour(boolean  reserved,String from, String to,String  reservedFrom )
     {
         this.reserved=reserved;
         this.from=from;
         this.to=to;
         this.reservedFrom = reservedFrom;
     }
     public void setFrom(String from) {
         this.from = from;
     }
     public String getFrom() {
         return from;
     }
     public void setTo(String to) {
         this.to = to;
     }

     public void setReserved(boolean reserved) {
     this.reserved = reserved;
     }
     public boolean getReserved() {
     return reserved;
     }
     public String getTo() {
         return to;
     }

    public void setReservedFrom(String reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public String getReservedFrom() {
        return reservedFrom;
    }
}


