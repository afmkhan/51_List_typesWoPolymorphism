/**
  Implement a list of integer intElements, including
  both data and operations.
 */

public class List_inArraySlots {

    private int[] intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of intElements in this list
    
    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements = new int[ INITIAL_CAPACITY];
        doubleElements = new double[ INITIAL_CAPACITY];
        stringElements = new String[ INITIAL_CAPACITY];
        typeOfElements = new int[ INITIAL_CAPACITY];
                
    }


    /**
      @return the number of intElements in this list
     */
    public int size() {
        return (intElements.length + doubleElements.length + stringElements.length);
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
    String total = "";
    total += System.lineSeparator();
    for (int i: intElements) {total += i + ", ";}
    total += System.lineSeparator();
    for (double d: doubleElements) {total += d + ", ";}
    total += System.lineSeparator();
    for (String s: stringElements) {total += s + ", ";}
    return (total);
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int intValue
                       , double doubleValue
                       , String stringValue
                       ) {
        if( filledElements == intElements.length) expand();
        
        typeOfElements[filledElements] = type;
        intElements[filledElements] = intValue;
        doubleElements[filledElements] = doubleValue;
        stringElements[filledElements++] = stringValue;
        return true;
                       
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
        int[] typeBigger = new int[ typeOfElements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            typeBigger[ elemIndex] = typeOfElements[ elemIndex];
        typeOfElements = typeBigger;
              
        int[] intBigger = new int[ intElements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            intBigger[ elemIndex] = intElements[ elemIndex];
        intElements = intBigger;
        
        double[] doubleBigger = new double[ doubleElements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            doubleBigger[ elemIndex] = doubleElements[ elemIndex];
        doubleElements = doubleBigger;      
        
        String[] stringBigger = new String[ stringElements.length * 2];
        for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
            stringBigger[ elemIndex] = stringElements[ elemIndex];
        stringElements = stringBigger;
        
      }
}
