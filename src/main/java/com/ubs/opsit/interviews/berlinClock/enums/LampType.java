package com.ubs.opsit.interviews.berlinClock.enums;

public enum LampType {

   RED("R"),
   YELLOW("Y"),
   OFF("O");

   private String indicator;

   LampType(String indicator){
       this.indicator = indicator;
   }

   public static String getIndicator(LampType lampType) {
      return lampType.indicator;
   }

   public String getIndicatorSeries(int count) {
      StringBuilder indicatorSeries = new StringBuilder();
      for(int i=0;i<count;i++) {
         indicatorSeries.append(getIndicator(this));
      }
      return indicatorSeries.toString();
   }
}
