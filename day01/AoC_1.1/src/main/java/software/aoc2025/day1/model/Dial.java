package software.aoc2025.day1.model;


public record Dial(int position, int timesTo0) {

    public Dial rotate(Rotation instruccion){

        int newCount = timesTo0;
        int distanceR = 100 - position;
        int distanceL = (position == 0) ? 100 : position;
        int x = instruccion.distance();

        int newPosition=0;

        if(instruccion.direction().equals("R")){
            newPosition = (position() + instruccion.distance()) % 100;

            while(x >= distanceR){
                x -= 100;
                newCount++;
            }
        }

        else{
            newPosition = ((position() -  instruccion.distance())%100 + 100) % 100;

            while(x >= distanceL) {
                x -= 100;
                newCount++;
            }
        }

        return new Dial(newPosition, newCount);
    }
}
