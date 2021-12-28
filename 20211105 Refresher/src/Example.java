public class Example {
    public static void main(String[] args) {
        System.out.println("We are making a new Pez Dispenser!");
        ClassRefresher refresher = new ClassRefresher();
        refresher.characterName = "MUAHAHAHHA";
        Integer counter = 0;
        do {
            System.out.printf("The count is %s %n", String.valueOf(counter));
            counter += 1;
        } while (counter <= 500);
    }
}
