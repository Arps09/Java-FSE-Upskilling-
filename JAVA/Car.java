class Car {
    String make, model;
    int year;

    void displayDetails() {
        System.out.println(make + " " + model + " " + year);
    }
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.make = "Toyota";
        myCar.model = "Corolla";
        myCar.year = 2020;
        myCar.displayDetails();
    }
}
