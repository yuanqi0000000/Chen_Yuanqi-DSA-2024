package oy.tol.tra;


public class Grades {
   
   private Integer [] grades = null;

   public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   public void reverse() {
      
      int i = 0;
      while (i <= (grades.length-1)/2) {
         int temp = grades[i];
         grades[i] = grades[grades.length-i-1];
         grades[grades.length-i-1] = temp;
         i++;
     }
   }

   public void sort() {

      for(int i=1;i < grades.length;i++){
         for(int j=i; (j>0) && (grades[j] < grades[j-1]);j--){
            int tmp = grades[j];
            grades[j] = grades[j-1];
            grades[j-1] = tmp;
         }
      }
   }


   public Integer [] getArray() {
      return grades;
   }
}
