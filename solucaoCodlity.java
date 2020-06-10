class Solution {
    public int solution(int N) {
        
        String invertedBinary = decimalToBinary(N);
        String correctBinary = reverseNumber(invertedBinary);
        int bigGap = biggestGap(correctBinary);

        return bigGap;
    }
    
    
    private String decimalToBinary(int N) {

    	if ((N == 2 && N % 2 == 0) || N / 2 < 2) {
			return Integer.toString(N % 2) + Integer.toString(N / 2);
		}
		return Integer.toString(N % 2) + decimalToBinary(N / 2);
	}

	private int biggestGap(String newOutput) {

		int contZeros = 0;
		int maxGap = 0;
		for (int i = 0; i < newOutput.length(); i++) {
	
			if (newOutput.charAt(i) == '0' && i != 0) {
				contZeros++;

			} else if (newOutput.charAt(i) == '1') {
				if (maxGap < contZeros) {
					maxGap = contZeros;
					contZeros = 0;
				}

			}

		}
		return maxGap;

	}
	
	private String reverseNumber(String stringBinaryInverted){
	    
	    String correctBinaryString = "";
		for (int i = stringBinaryInverted.length() - 1; i >= 0; i--) {
			correctBinaryString += stringBinaryInverted.charAt(i);
		}
		
		return correctBinaryString;
	}
}
