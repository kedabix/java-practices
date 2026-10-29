package semester1.practice08;

import semester1.practice08.block1.*;
import semester1.practice08.block2.*;
import semester1.practice08.block3.*;
import semester1.practice08.block4.*;
import semester1.practice08.block5.*;

public class Practice08 {

    public static void main(String[] args) {
        // Блок 1
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        // Блок 2
        task09();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        // Блок 3
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
        task23();
        task24();
        // Блок 4
        task25();
        task26();
        task27();
        task28();
        task29();
        task30();
        task31();
        task32();
        // Блок 5
        task33();
        task34();
        task35();
        task36();
        task37();
        task38();
        task39();
        // Завдання 40 - це коміт і push у GitHub (робиться в Git, коду не потребує)
    }

    private static void header(int number, String title) {
        System.out.println();
        System.out.println("===== Завдання " + number + ": " + title + " =====");
    }

    // ---------------- Блок 1 ----------------

    private static void task01() {
        header(1, "Student");
        Student student = new Student("Оля", 2, 88.5);
        System.out.println(student);
        Student bad = new Student("Помилка", 10, 150);
        System.out.println(bad);
        student.setCourse(9);
        System.out.println("Після setCourse(9): " + student);
    }

    private static void task02() {
        header(2, "Product");
        Product p1 = new Product("A-101", "Монітор", 6499.50, 4);
        Product p2 = new Product("B-202", "Миша", -50, -3);
        System.out.println(p1);
        System.out.println(p2);
    }

    private static void task03() {
        header(3, "Circle");
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(-3);
        System.out.println(c1);
        System.out.println(c2);
        c1.setRadius(0);
        System.out.println("Після setRadius(0): " + c1);
    }

    private static void task04() {
        header(4, "CardWallet");
        CardWallet wallet = new CardWallet("1234567812344589", "1111", 12500);
        System.out.println(wallet);
        System.out.println("Зміна PIN зі старим невірним: " + wallet.changePin("0000", "2222"));
        System.out.println("Зміна PIN зі старим вірним: " + wallet.changePin("1111", "2222"));
        System.out.println(wallet);
    }

    // Клас-нащадок у іншому пакеті бачить protected-поле батька
    private static class DemoSensor extends SensorNode {
        public DemoSensor(String id, double raw, double offset) {
            super(id, raw, offset);
        }

        public void recalibrate(double newOffset) {
            calibrationOffset = newOffset; // protected доступний у спадкоємці
        }
    }

    private static void task05() {
        header(5, "SensorNode (protected)");
        DemoSensor sensor = new DemoSensor("T-1", 20.0, 0.5);
        System.out.println(sensor);
        sensor.recalibrate(-1.5);
        System.out.println("Після перекалібрування: " + sensor);
    }

    private static void task06() {
        header(6, "WeatherDay");
        double[] temps = {12.5, 14.0, 18.5, 20.0, 16.5};
        WeatherDay day = new WeatherDay("28.10.2026", temps);
        System.out.println(day);
        temps[0] = 100; // зовнішній масив змінили, а об'єкт - ні
        System.out.println("Після зміни зовнішнього масиву: " + day);
        System.out.println("Мін: " + day.getMinTemp() + ", макс: " + day.getMaxTemp());
    }

    private static void task07() {
        header(7, "IntRange");
        IntRange r1 = new IntRange(1, 10);
        IntRange r2 = new IntRange(50, 20);
        System.out.println(r1);
        System.out.println(r2 + " (межі були поміняні місцями)");
        System.out.println("r1 містить 5? " + r1.contains(5));
        System.out.println("r2 містить 100? " + r2.contains(100));
    }

    private static void task08() {
        header(8, "InvoiceItem");
        InvoiceItem item = new InvoiceItem("Зошит", 10, 45.0, 20);
        System.out.println("Позиція чека: " + item);
        System.out.println("Сума: " + item.getFinalAmount());
    }

    // ---------------- Блок 2 ----------------

    private static void task09() {
        header(9, "Employee та Developer");
        Employee e = new Employee("Олег", 20000);
        Developer d = new Developer("Марія", 45000, "Java");
        System.out.println(e);
        System.out.println(d);
    }

    private static void task10() {
        header(10, "Animal, Dog, Cat");
        Dog dog = new Dog("Рекс", 3, 25.5, "Вівчарка");
        Cat cat = new Cat("Мурка", 2, 4.2, true);
        System.out.println(dog);
        System.out.println(dog.fetchStick());
        System.out.println(cat);
        System.out.println(cat.purr());
    }

    private static void task11() {
        header(11, "Vehicle, PassengerCar, CargoTruck");
        PassengerCar car = new PassengerCar("Toyota", 200, 55, 5);
        CargoTruck truck = new CargoTruck("MAN", 110, 400, 12);
        System.out.println(car);
        System.out.println(truck);
    }

    private static void task12() {
        header(12, "Rectangle та Box3D");
        Rectangle rect = new Rectangle(3, 4);
        Box3D box = new Box3D(3, 4, 5);
        System.out.println(rect);
        System.out.println(box);
    }

    private static void task13() {
        header(13, "Person, UniversityStudent, Professor");
        UniversityStudent student = new UniversityStudent("Іван Коваль", 2006, "ST-001", "Програмування", 2000);
        Professor professor = new Professor("Петро Мельник", 1975, "Доцент", 42);
        System.out.println(student);
        System.out.println("Вік студента: " + student.getAge(2026));
        System.out.println(professor);
        System.out.println("Вік професора: " + professor.getAge(2026));
    }

    private static void task14() {
        header(14, "Gadget та Smartphone");
        Smartphone s1 = new Smartphone("Samsung", 25000, 256, true);
        Smartphone s2 = new Smartphone("Xiaomi", 12000, 128);
        Smartphone s3 = new Smartphone("Nokia");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    private static void task15() {
        header(15, "Publication, PrintedBook, AudioBook");
        PrintedBook book = new PrintedBook("Кобзар", "Тарас Шевченко", 1840, 320, "тверда");
        AudioBook audio = new AudioBook("Захар Беркут", "Іван Франко", 1883, 135, "Андрій Сміян");
        System.out.println(book);
        System.out.println(audio);
    }

    private static void task16() {
        header(16, "Gamer та ProEsportsPlayer");
        Gamer gamer = new Gamer("Noob", 120);
        ProEsportsPlayer pro = new ProEsportsPlayer("Simple", 15000, "NAVI", 250000, 5);
        ProEsportsPlayer newbie = new ProEsportsPlayer("Rookie", 800, "Academy", 0, 0);
        System.out.println(gamer);
        System.out.println(pro);
        System.out.println(newbie);
    }

    // ---------------- Блок 3 ----------------

    private static void task17() {
        header(17, "StaffMember, Manager, SalesPerson");
        StaffMember staff = new StaffMember("Ігор", 15000);
        Manager manager = new Manager("Анна", 25000, 5000);
        SalesPerson seller = new SalesPerson("Богдан", 10000, 200000, 3);
        System.out.println(staff);
        System.out.println(manager);
        System.out.println(seller);
    }

    private static void task18() {
        header(18, "StandardTransfer та InternationalTransfer");
        StandardTransfer standard = new StandardTransfer(1000);
        InternationalTransfer international = new InternationalTransfer(1000, "PL");
        System.out.println(standard);
        System.out.println(international);
    }

    private static void task19() {
        header(19, "Ticket, StudentTicket, VipTicket");
        Ticket ticket = new Ticket("Концерт", 800);
        StudentTicket student = new StudentTicket("Концерт", 800, "KB123456");
        VipTicket vip = new VipTicket("Концерт", 800, true, 1200);
        System.out.println(ticket);
        System.out.println(student);
        System.out.println(vip);
    }

    private static void task20() {
        header(20, "Weapon та EnchantedSword");
        Weapon sword = new Weapon("Звичайний меч", 30);
        EnchantedSword fireSword = new EnchantedSword("Вогняний меч", 30, "Вогонь", 8, 3);
        System.out.println(sword);
        System.out.println(fireSword);
    }

    private static void task21() {
        header(21, "Parcel та FragileParcel");
        Parcel parcel = new Parcel("UA-001", 2.5);
        FragileParcel fragile = new FragileParcel("UA-002", 2.5, true, 4000);
        System.out.println(parcel);
        System.out.println(fragile);
    }

    private static void task22() {
        header(22, "Appliance та EcoHeater");
        Appliance appliance = new Appliance("Чайник", 2000);
        EcoHeater eco = new EcoHeater("Обігрівач", 1500, true);
        EcoHeater normal = new EcoHeater("Обігрівач", 1500, false);
        System.out.println(appliance + ": " + appliance.getDailyConsumptionKWh(2) + " кВт*год за 2 год");
        System.out.println(eco + ": " + eco.getDailyConsumptionKWh(8) + " кВт*год за 8 год");
        System.out.println(normal + ": " + normal.getDailyConsumptionKWh(8) + " кВт*год за 8 год");
    }

    private static void task23() {
        header(23, "Point2D та Point3D");
        Point2D p2 = new Point2D(3, 4);
        Point3D p3 = new Point3D(1, 2, 2);
        System.out.println(p2 + " відстань до початку: " + p2.distanceToOrigin());
        System.out.println(p3 + " відстань до початку: " + p3.distanceToOrigin());
    }

    private static void task24() {
        header(24, "Coffee та LatteWithAddons");
        Coffee coffee = new Coffee("Темне", 250, 50);
        LatteWithAddons latte = new LatteWithAddons("Середнє", 300, 65, "Рослинне", 2);
        System.out.println(coffee);
        System.out.println(latte);
    }

    // ---------------- Блок 4 ----------------

    private static void task25() {
        header(25, "DotaHero -> StrengthHero -> AlchemistHero");
        DotaHero hero = new DotaHero("Invoker", "Universal", 500);
        StrengthHero strengthHero = new StrengthHero("Axe", 600, 25);
        AlchemistHero alchemist = new AlchemistHero(620, 26, 150);
        System.out.println(hero);
        System.out.println(strengthHero);
        System.out.println(alchemist);
        System.out.println(alchemist.chemicalRage());
    }

    private static void task26() {
        header(26, "BaseVehicle -> MotorCar -> ElectricCar");
        ElectricCar tesla = new ElectricCar("Tesla", 2024, 670, 4, 100.0, 600);
        System.out.println(tesla);
    }

    private static void task27() {
        header(27, "PaymentCard -> DebitCard -> CashbackPlatinumCard");
        CashbackPlatinumCard card = new CashbackPlatinumCard("Олена", 20000, 5000, 5);
        System.out.println(card);
        System.out.println("Оплата 3000: " + card.pay(3000));
        System.out.println("Оплата 6000 (понад ліміт): " + card.pay(6000));
        System.out.println("Оплата 1000: " + card.pay(1000));
        System.out.println(card);
    }

    private static void task28() {
        header(28, "SecurityTerminal (final метод)");
        SecurityTerminal terminal = new SecurityTerminal();
        CustomTerminal custom = new CustomTerminal("admin");
        System.out.println(terminal.getWelcomeBanner());
        System.out.println(terminal.generateAuthHash("guest"));
        System.out.println(custom.getWelcomeBanner());
    }

    private static void task29() {
        header(29, "ImmutableServerCredentials (final клас)");
        ImmutableServerCredentials credentials = new ImmutableServerCredentials("192.168.0.1", 8080, "abc-123-secret");
        System.out.println(credentials);
        System.out.println("Хост: " + credentials.getHost() + ", порт: " + credentials.getPort());
        // class Hacker extends ImmutableServerCredentials {}  <- помилка компіляції: клас final
    }

    private static void task30() {
        header(30, "Segment1D -> Square2D -> Cube3D");
        Segment1D segment = new Segment1D(5);
        Square2D square = new Square2D(5);
        Cube3D cube = new Cube3D(5);
        System.out.println(segment);
        System.out.println(square);
        System.out.println(cube);
    }

    private static void task31() {
        header(31, "User -> StudentUser -> PostgraduateStudent");
        PostgraduateStudent good = new PostgraduateStudent(1, "good@uni.ua", "AS-21", 92.0,
                "Нейромережі в медицині", "проф. Іваненко");
        PostgraduateStudent bad = new PostgraduateStudent(2, "bad@uni.ua", "AS-22", 70.0,
                "", "доц. Петренко");
        System.out.println(good);
        System.out.println(bad);
    }

    private static void task32() {
        header(32, "Medicine -> PrescriptionMedicine -> ControlledSubstance");
        Medicine vitamin = new Medicine("Вітамін C", 120, false);
        PrescriptionMedicine antibiotic = new PrescriptionMedicine("Антибіотик", 250, false, "LIC-77");
        ControlledSubstance strong = new ControlledSubstance("Сильнодіючий", 900, false, "LIC-99", 16);
        ControlledSubstance adult = new ControlledSubstance("Сильнодіючий", 900, false, "LIC-99", 30);
        ControlledSubstance expired = new ControlledSubstance("Сильнодіючий", 900, true, "LIC-99", 30);

        System.out.println(vitamin);
        System.out.println("Антибіотик з рецептом: " + antibiotic.canSell(true));
        System.out.println("Антибіотик без рецепта: " + antibiotic.canSell(false));
        System.out.println("Пацієнт 16 років, з рецептом: " + strong.canSell(true));
        System.out.println("Пацієнт 30 років, з рецептом: " + adult.canSell(true));
        System.out.println("Прострочений, з рецептом: " + expired.canSell(true));
        System.out.println(adult);
    }

    // ---------------- Блок 5 ----------------

    private static void task33() {
        header(33, "Progression");
        ArithmeticProgression arithmetic = new ArithmeticProgression(2, 3);
        GeometricProgression geometric = new GeometricProgression(1, 2);
        System.out.println(arithmetic);
        System.out.println(geometric);
        double[] first10 = arithmetic.generateFirstN(10);
        System.out.println("10-й член арифметичної прогресії: " + first10[9]);
    }

    private static void task34() {
        header(34, "GradeSheet та WeightedGradeSheet");
        int[] grades = {90, 70, 100};
        double[] weights = {1, 2, 3};
        GradeSheet simple = new GradeSheet("Оля", grades);
        WeightedGradeSheet weighted = new WeightedGradeSheet("Оля", grades, weights);
        System.out.println(simple);
        System.out.println(weighted);
    }

    private static void task35() {
        header(35, "LinearFunction та QuadraticFunction");
        LinearFunction line = new LinearFunction(2, 1);
        QuadraticFunction parabola = new QuadraticFunction(1, -4, 3);
        System.out.println(line + ", f(3) = " + line.evaluate(3));
        System.out.println(parabola + ", f(3) = " + parabola.evaluate(3));
        System.out.println("Вершина параболи: x0 = " + parabola.getVertexX());
    }

    private static void task36() {
        header(36, "WarehouseItem та DiscountedWarehouseItem");
        double[] prices = {100, 110, 90};
        WarehouseItem item = new WarehouseItem("Клавіатура", 20, prices);
        DiscountedWarehouseItem sale = new DiscountedWarehouseItem("Клавіатура", 20, prices, "Пошкоджена упаковка", 30);
        System.out.println(item);
        System.out.println(sale);
    }

    private static void task37() {
        header(37, "CinemaHall та VipCinemaHall");
        CinemaHall hall = new CinemaHall("Зал 1", 3, 4, 150);
        hall.bookSeat(1, 1);
        hall.bookSeat(2, 3);
        hall.bookSeat(2, 3); // спроба забронювати двічі
        System.out.println(hall);

        System.out.println();
        VipCinemaHall vip = new VipCinemaHall("VIP зал", 3, 4, 300, 100);
        vip.bookSeat(1, 2);
        vip.bookSeat(3, 1);
        vip.bookSeat(3, 2);
        System.out.println(vip);
    }

    private static void task38() {
        header(38, "TeamLead");
        TeamLead lead = new TeamLead("Дмитро", 80000, "Java", 3);
        lead.addTeamMember(new Developer("Анна", 45000, "Java"));
        lead.addTeamMember(new Developer("Максим", 40000, "Python"));
        System.out.println(lead);
    }

    private static void task39() {
        header(39, "CharacterUnit та ShieldedPaladin");
        CharacterUnit warrior = new CharacterUnit("Воїн", 100, 5);
        ShieldedPaladin paladin = new ShieldedPaladin("Паладин", 100, 5, 30);
        System.out.println(warrior);
        System.out.println(paladin);

        System.out.println("-- Удар на 20 --");
        warrior.takeDamage(20);
        paladin.takeDamage(20);
        System.out.println(warrior);
        System.out.println(paladin);

        System.out.println("-- Удар на 40 (щит пробито) --");
        warrior.takeDamage(40);
        paladin.takeDamage(40);
        System.out.println(warrior);
        System.out.println(paladin);
    }
}
