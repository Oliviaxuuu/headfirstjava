package DotComGame;

public class SimpleDotCom {
    int[] locationCells;
    int numofHits = 0;

    public int[] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public int getNumofHits() {
        return numofHits;
    }

    public void setNumofHits(int numofHits) {
        this.numofHits = numofHits;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);

        String result = "miss";

        for(int cell : locationCells) {
            if(guess == cell) {
                result = "hit";
                numofHits++;
                break;
            }
        }
        if(numofHits == locationCells.length) {
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
