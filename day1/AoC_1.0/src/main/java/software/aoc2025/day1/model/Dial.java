package software.aoc2025.day1.model;

public record Dial(int position, int timesTo0) {

    public Dial rotate(Rotation instruccion){
        int newPosition=0;

        if(instruccion.direction().equals("R")){
            newPosition = (position() + instruccion.distance()) % 100;        // 99 + 1 -> 0, 100 % 100 == 0
        }

        else{
            newPosition = ((position() -  instruccion.distance())%100 + 100) % 100;
        }

        int newCount = timesTo0;
        if(newPosition == 0){
            newCount = timesTo0 +1;
        }
        return new Dial(newPosition, newCount);
    }
}
