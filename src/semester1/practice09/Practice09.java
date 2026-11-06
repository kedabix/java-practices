package semester1.practice09;

import java.util.Arrays;
import java.util.Locale;

/**
 * Практична робота №9: інкапсуляція, композиція та абстрактні класи.
 * Класи для завдань лежать у файлах Block1..Block5 цього ж пакета.
 */
public class Practice09 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // щоб числа друкувались із крапкою

        // Блок 1: інкапсуляція
        task1(); task2(); task3(); task4(); task5(); task6(); task7(); task8();
        // Блок 2: композиція та агрегація
        task9(); task10(); task11(); task12(); task13(); task14(); task15(); task16();
        // Блок 3: композиція з масивами
        task17(); task18(); task19(); task20(); task21(); task22(); task23(); task24();
        // Блок 4: абстрактні класи
        task25(); task26(); task27(); task28(); task29(); task30(); task31(); task32();
        // Блок 5: синергія
        task33(); task34(); task35(); task36(); task37(); task38(); task39(); task40();
    }

    private static void header(int n, String title) {
        System.out.println("\n=== Завдання " + n + ": " + title + " ===");
    }

    // ------------------------------------------------------------------
    // БЛОК 1
    // ------------------------------------------------------------------

    static void task1() {
        header(1, "ImmutableGeoPoint");
        ImmutableGeoPoint kyiv = new ImmutableGeoPoint(50.4501, 30.5234);
        ImmutableGeoPoint moved = kyiv.shift(0.5, -0.25);
        ImmutableGeoPoint clamped = new ImmutableGeoPoint(120.0, 200.0);
        System.out.println("Київ:      " + kyiv);
        System.out.println("Зміщена:   " + moved);
        System.out.println("Оригінал після shift() не змінився: " + kyiv);
        System.out.println("Поза межами притиснуто: " + clamped);
    }

    static void task2() {
        header(2, "LabMeasurement (захисне копіювання)");
        double[] raw = {1.5, 2.5, 3.5};
        LabMeasurement m = new LabMeasurement("Опір провідника", raw);
        raw[0] = 999.0; // псуємо вхідний масив ззовні
        double[] got = m.getSamples();
        got[1] = -1.0;  // псуємо отриманий масив
        System.out.println("Після псування ззовні: " + m);
    }

    static void task3() {
        header(3, "CryptoVault");
        CryptoVault vault = new CryptoVault("bc1qxy2kgdyg", "correct horse battery", 1.5);
        System.out.println(vault);
        System.out.println("Відправка до розблокування: " + vault.sendBtc(0.2, "bc1abc"));
        System.out.println("Невірна фраза: " + vault.unlock("wrong phrase"));
        System.out.println("Вірна фраза:   " + vault.unlock("correct horse battery"));
        System.out.println("Відправка 0.2 BTC: " + vault.sendBtc(0.2, "bc1abc"));
        System.out.println("Відправка 5 BTC (забагато): " + vault.sendBtc(5, "bc1abc"));
        System.out.println(vault);
    }

    static void task4() {
        header(4, "ClosedInterval");
        ClosedInterval a = new ClosedInterval(10, 2); // start > end, перевпорядкується
        ClosedInterval b = new ClosedInterval(8, 15);
        ClosedInterval c = new ClosedInterval(20, 30);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a перетинається з b: " + a.overlaps(b));
        System.out.println("a перетинається з c: " + a.overlaps(c));
        a.resize(5, 1);
        System.out.println("a після resize(5, 1): " + a);
    }

    static void task5() {
        header(5, "RgbColor");
        RgbColor orange = new RgbColor(255, 165, 0);
        RgbColor blue = new RgbColor(0, 0, 255);
        System.out.println("Помаранчевий: " + orange);
        System.out.println("Інверсія:     " + orange.invert());
        System.out.println("Мікс з синім: " + orange.mixWith(blue));
        System.out.println("Поза межами:  " + new RgbColor(300, -20, 128));
    }

    static void task6() {
        header(6, "HighSecuritySafe");
        HighSecuritySafe safe = new HighSecuritySafe(1234, 5000);
        System.out.println("Покласти 1000 з правильним PIN: " + safe.putCash(1234, 1000));
        System.out.println("Взяти 500 з неправильним PIN:   " + safe.takeCash(1111, 500));
        System.out.println("Взяти 500 з неправильним PIN:   " + safe.takeCash(2222, 500));
        System.out.println(safe);
        System.out.println("Взяти 500 з вірним PIN (скидає лічильник): " + safe.takeCash(1234, 500));
        safe.takeCash(0, 1);
        safe.takeCash(0, 1);
        safe.takeCash(0, 1);
        System.out.println(safe);
        System.out.println("Вірний PIN після блокування: " + safe.takeCash(1234, 100));
    }

    static void task7() {
        header(7, "EncapsulatedPolynomial");
        EncapsulatedPolynomial p = new EncapsulatedPolynomial(1, -3, 2, 0, 0); // 2x^2 - 3x + 1
        System.out.println(p);
        System.out.println("Степінь: " + p.getDegree());
        System.out.println("P(2) = " + p.evaluate(2));
        System.out.println("Коеф. при x^2 = " + p.getCoefficient(2) + ", при x^5 = " + p.getCoefficient(5));
        System.out.println(new EncapsulatedPolynomial(0, 1));
        System.out.println(new EncapsulatedPolynomial(5));
        try {
            p.getCoefficient(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static void task8() {
        header(8, "MedicalRecord");
        String[] allergies = {"пеніцилін", "пилок"};
        MedicalRecord rec = new MedicalRecord("P-001", "Іваненко Іван Іванович", 2, true, allergies);
        allergies[0] = "нічого"; // ззовні змінити вже не можна
        rec.getAllergies()[1] = "нічого";
        System.out.println(rec);
        System.out.println("Алергія на пеніцилін: " + rec.hasAllergyTo("Пеніцилін"));
        System.out.println("Алергія на аспірин:   " + rec.hasAllergyTo("аспірин"));
        try {
            new MedicalRecord("P-002", "Тест", 7, true, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------------
    // БЛОК 2
    // ------------------------------------------------------------------

    static void task9() {
        header(9, "CompositeCircle");
        CompositeCircle circle = new CompositeCircle(0, 0, 5);
        System.out.println(circle);
        System.out.println("(3; 4) всередині: " + circle.containsPoint(new Point2D(3, 4)));
        System.out.println("(4; 4) всередині: " + circle.containsPoint(new Point2D(4, 4)));
    }

    static void task10() {
        header(10, "Automobile + Engine");
        Automobile car = new Automobile("Toyota Camry", new Engine("бензин", 2500));
        car.accelerate(30);
        car.getEngine().start();
        car.accelerate(60);
        System.out.println(car);
        car.accelerate(500);
        System.out.println(car);
        car.getEngine().stop();
        System.out.println(car);
    }

    static void task11() {
        header(11, "SmartDevice");
        SmartDevice phone = new SmartDevice(new Battery(5000, 40), new Display(6.7, 80));
        System.out.println(phone);
        phone.watchVideo(60); // яскравість 80 > 70: втрата 6 * 2 = 12%
        System.out.println("Після 60 хв при яскравості 80%: " + phone);
        phone.getDisplay().setBrightnessPercent(30);
        phone.watchVideo(60); // втрата 6%
        System.out.println("Після 60 хв при яскравості 30%: " + phone);
        phone.getDisplay().setBrightnessPercent(100);
        phone.watchVideo(120);
        System.out.println(phone);
        phone.watchVideo(10);
    }

    static void task12() {
        header(12, "LineSegment (захисні копії)");
        Point2D a = new Point2D(0, 0);
        Point2D b = new Point2D(6, 8);
        LineSegment seg = new LineSegment(a, b);
        a.translate(100, 100); // ззовні точки вже не вплинуть на відрізок
        System.out.println(seg);
        System.out.println("Середина: " + seg.getMidpoint());
    }

    static void task13() {
        header(13, "PlasticCard + BankAccount");
        BankAccount account = new BankAccount("UA213223130000026007233566001", 1000);
        PlasticCard card1 = new PlasticCard("4149123456781234", "12/28", account);
        PlasticCard card2 = new PlasticCard("5375987654325678", "03/27", account);
        System.out.println(card1);
        System.out.println("Оплата карткою 1 (300): " + card1.payAtTerminal(300));
        System.out.println("Оплата карткою 2 (500): " + card2.payAtTerminal(500));
        System.out.println(account);
        card1.block();
        System.out.println(card1);
        System.out.println("Оплата заблокованою карткою: " + card1.payAtTerminal(10));
        System.out.println("Оплата карткою 2 (500, не вистачає): " + card2.payAtTerminal(500));
        System.out.println(account);
    }

    static void task14() {
        header(14, "HeroCharacter + WeaponItem");
        HeroCharacter hero = new HeroCharacter("Аргон", 20);
        WeaponItem sword = new WeaponItem("Меч", 15, 30);
        System.out.println(hero);
        System.out.println("Удар без зброї: " + hero.attack());
        hero.equip(sword);
        for (int i = 1; i <= 4; i++) {
            System.out.println("Удар " + i + " з мечем: " + hero.attack() + "  -> " + hero);
        }
        hero.unequip();
        System.out.println("Зброю знято: " + hero);
    }

    static void task15() {
        header(15, "ParcelOrder + DeliveryAddress");
        DeliveryAddress addr = new DeliveryAddress("Київ", "Хрещатик", 12);
        ParcelOrder order = new ParcelOrder("ORD-77", 2.5, addr);
        System.out.println(order);
        System.out.println("Зміна адреси: " + order.changeDestination(new DeliveryAddress("Львів", "Городоцька", 5)));
        System.out.println("Некоректна адреса: " + order.changeDestination(new DeliveryAddress("", "Вулиця", 0)));
        System.out.println(order);
        order.markAsShipped();
        System.out.println("Зміна після відправки: " + order.changeDestination(new DeliveryAddress("Одеса", "Дерибасівська", 1)));
        System.out.println(order);
    }

    static void task16() {
        header(16, "ClimateController");
        ClimateController ctrl = new ClimateController(18.0, 22.0, 2.5);
        double[] readings = {18.0, 21.0, 21.8, 22.3, 21.7, 21.4};
        for (double t : readings) {
            ctrl.updateRoomTemperature(t);
            ctrl.regulate();
            System.out.println(ctrl);
        }
    }

    // ------------------------------------------------------------------
    // БЛОК 3
    // ------------------------------------------------------------------

    static void task17() {
        header(17, "Polyline");
        Polyline line = new Polyline(5);
        line.addVertex(0, 0);
        line.addVertex(3, 4);
        line.addVertex(3, 0);
        System.out.printf("Вершин: %d, довжина ламаної: %.2f, периметр замкненої: %.2f%n",
                line.getCount(), line.getTotalLength(), line.getClosedPerimeter());
        Polyline small = new Polyline(2);
        System.out.println("Додавання до повної ламаної: "
                + (small.addVertex(0, 0) && small.addVertex(1, 1) && small.addVertex(2, 2)));
    }

    static void task18() {
        header(18, "ShoppingOrder");
        ShoppingOrder order = new ShoppingOrder();
        order.addItem("Хліб", 25.50, 2);
        order.addItem("Молоко", 42.00, 1);
        order.addItem("хліб", 25.50, 1); // об'єднається з першою позицією
        order.addItem("Сир", 180.00, 3);
        System.out.println(order);
    }

    static void task19() {
        header(19, "Bookshelf");
        Bookshelf shelf = new Bookshelf("Фентезі", 3);
        shelf.putBook(new BookItem("Гобіт", "Толкін", 310));
        shelf.putBook(new BookItem("Володар перснів", "Толкін", 1178));
        shelf.putBook(new BookItem("Відьмак", "Сапковський", 360));
        System.out.println("Четверта книга: " + shelf.putBook(new BookItem("Ще книга", "Автор", 100)));
        System.out.println("Найтовща: " + shelf.findLongestBook());
        System.out.println("Всього сторінок: " + shelf.getTotalPagesOnShelf());
    }

    static void task20() {
        header(20, "Playlist");
        Playlist pl = new Playlist("Ранкова", 4);
        pl.addTrack(new AudioTrack("Shape of You", "Ed Sheeran", 234));
        pl.addTrack(new AudioTrack("Believer", "Imagine Dragons", 204));
        pl.addTrack(new AudioTrack("Intro", "Anonymous", 65));
        System.out.println(pl);
    }

    static void task21() {
        header(21, "DataCenterCluster");
        DataCenterCluster cluster = new DataCenterCluster("Київ-1", 4);
        cluster.addNode(new ServerNode("10.0.0.1", 32, true));
        cluster.addNode(new ServerNode("10.0.0.2", 64, false));
        cluster.addNode(new ServerNode("10.0.0.3", 16, true));
        cluster.deployContainer(24);
        cluster.deployContainer(24); // на першому вузлі лишилось 8, на третьому 16: місця немає
        cluster.deployContainer(16);
        cluster.deployContainer(48);
        System.out.println(cluster);
    }

    static void task22() {
        header(22, "UniversityCourse");
        UniversityCourse course = new UniversityCourse("Основи програмування", 5);
        course.addModule(new CourseModule("Основи Java", 16, 32, 30));
        course.addModule(new CourseModule("ООП", 16, 32, 40));
        course.addModule(new CourseModule("Колекції", 12, 24, 30));
        System.out.printf("%s: %.2f ЄКТС, максимум балів %.1f%n",
                course.getCourseTitle(), course.getEctsCredits(), course.getTotalMaxScore());
        System.out.println("Сума рівно 100: " + course.isScoreExactly100());
    }

    static void task23() {
        header(23, "PassengerTrain");
        PassengerTrain train = new PassengerTrain("Київ - Львів", 3);
        train.attachCarriage(new TrainCarriage(1, "Купе", 36));
        train.attachCarriage(new TrainCarriage(2, "Плацкарт", 54));
        train.attachCarriage(new TrainCarriage(3, "Інтерсіті", 60));
        System.out.println("Бронь 4 місць у вагоні 1: " + train.bookTicketsInCarriage(1, 4));
        System.out.println("Бронь 100 місць у вагоні 2: " + train.bookTicketsInCarriage(2, 100));
        System.out.println("Бронь у неіснуючому вагоні 9: " + train.bookTicketsInCarriage(9, 1));
        System.out.println(train);
        try {
            new TrainCarriage(4, "Люкс", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static void task24() {
        header(24, "EquationSystem");
        EquationSystem system = new EquationSystem(3);
        system.addEquation(new LinearEquation(2, 1, 7)); // 2x + y = 7
        system.addEquation(new LinearEquation(1, -1, -1)); // x - y = -1
        System.out.println("x=2, y=3: " + system.checkSolution(2, 3));
        System.out.println("x=1, y=5: " + system.checkSolution(1, 5));
        System.out.println("Порожня система: " + new EquationSystem(2).checkSolution(0, 0));
    }

    // ------------------------------------------------------------------
    // БЛОК 4
    // ------------------------------------------------------------------

    static void task25() {
        header(25, "AbstractShape");
        AbstractShape[] shapes = {new CircleShape("червоний", 2.0), new RectangleShape("синій", 3.0, 4.5)};
        for (AbstractShape s : shapes) {
            System.out.println(s);
        }
    }

    static void task26() {
        header(26, "AbstractPowerPlant");
        AbstractPowerPlant[] plants = {
                new SolarPowerPlant("Сонячна-1", 100, 0.6),
                new WindPowerPlant("Вітрова-1", 80, 7.5),
                new WindPowerPlant("Вітрова-2", 80, 30)
        };
        double tariff = 1500;
        for (AbstractPowerPlant p : plants) {
            System.out.printf("%-10s: %.1f МВт, прибуток за добу %.0f грн%n",
                    p.getStationName(), p.generateMegawatts(), p.calculateDailyProfit(tariff));
        }
    }

    static void task27() {
        header(27, "AbstractEmployee");
        AbstractEmployee[] team = {
                new SalariedEmployee(1, "Олена", 40000, 5000),
                new HourlyContractor(2, "Максим", 140, 250),
                new HourlyContractor(3, "Дарина", 180, 250)
        };
        for (AbstractEmployee e : team) {
            System.out.println(e);
        }
    }

    static void task28() {
        header(28, "AbstractSequence");
        AbstractSequence[] seqs = {new HarmonicSequence(), new SquareNumbersSequence()};
        for (AbstractSequence s : seqs) {
            System.out.printf("%s -> сума перших 10 = %.4f%n", s.getTitle(), s.sumFirstN(10));
        }
    }

    static void task29() {
        header(29, "AbstractTransaction");
        AbstractTransaction[] txs = {
                new DomesticTransfer("TX-1", 10000),
                new DomesticTransfer("TX-2", 200),
                new CryptoTransfer("TX-3", 5000, 85.5)
        };
        for (AbstractTransaction t : txs) {
            System.out.printf("%s: сума %.2f, комісія %.2f, списано %.2f%n",
                    t.getTxId(), t.amount, t.calculateCommission(), t.getTotalDebit());
        }
    }

    static void task30() {
        header(30, "Solid3D");
        Solid3D[] solids = {
                new Sphere3D("Сталь", 7850, 0.1),
                new Cylinder3D("Золото", 19320, 0.05, 0.2)
        };
        for (Solid3D s : solids) {
            System.out.printf("%s %s: об'єм %.6f м3, поверхня %.4f м2, маса %.2f кг%n",
                    s.getClass().getSimpleName(), s.getMaterialName(),
                    s.getVolume(), s.getSurfaceArea(), s.getMassKg());
        }
    }

    static void task31() {
        header(31, "AbstractSensor");
        PressureSensor pressure = new PressureSensor("Котел", 1.0, 6.0, 1.05);
        RadiationSensor radiation = new RadiationSensor("Склад", 0.0, 0.3);
        pressure.setRawReading(5.0);
        radiation.setMicroSvPerHour(0.12);
        AbstractSensor[] sensors = {pressure, radiation};
        for (AbstractSensor s : sensors) {
            System.out.println(s + " -> тривога: " + s.isAlarmTriggered());
        }
        pressure.setRawReading(7.0);
        radiation.setMicroSvPerHour(0.9);
        System.out.println("Після зміни показників:");
        for (AbstractSensor s : sensors) {
            System.out.println(s + " -> тривога: " + s.isAlarmTriggered());
        }
    }

    static void task32() {
        header(32, "AbstractCompressor");
        AbstractCompressor[] compressors = {new ZipCompressor(), new UltraLzmaCompressor()};
        int[] sizes = {1_000_000, 10_000, 100};
        for (int size : sizes) {
            System.out.println("Файл " + size + " байт:");
            for (AbstractCompressor c : compressors) {
                System.out.printf("  %-10s -> %d байт, стиснення %.2f%%%n",
                        c.getAlgorithmName(), c.estimateCompressedSize(size), c.getCompressionRatio(size));
            }
        }
    }

    // ------------------------------------------------------------------
    // БЛОК 5
    // ------------------------------------------------------------------

    static void task33() {
        header(33, "DesktopPC");
        DesktopPC pc = new DesktopPC(550);
        pc.addPart(new ProcessorPart("Ryzen 7 7700", 11000, 8, 105));
        pc.addPart(new VideoCardPart("RTX 4060", 17000, 8, 115));
        System.out.println(pc);
        pc.addPart(new VideoCardPart("RTX 4090", 90000, 24, 450));
        System.out.println(pc);
        System.out.printf("Загальна вартість: %.0f грн%n", pc.getTotalPrice());
    }

    static void task34() {
        header(34, "Spacecraft");
        Spacecraft ship = new Spacecraft("Артеміда", 50);
        ship.addThruster(new ChemicalThruster("C-1", 120, 38.0));
        ship.addThruster(new ChemicalThruster("C-2", 120, 38.0));
        System.out.printf("%s (хімічні): тяга %.1f кН, прискорення %.3f м/с2, витрата %.1f кг/с%n",
                ship.getShipName(), ship.getTotalThrustKn(), ship.getInitialAcceleration(), ship.getTotalFuelBurnRate());
        Spacecraft ion = new Spacecraft("Зонд-Іон", 5);
        for (int i = 1; i <= 4; i++) {
            ion.addThruster(new IonThruster("I-" + i, 100, 0.65, 30));
        }
        System.out.printf("%s (іонні): тяга %.5f кН, прискорення %.6f м/с2, витрата %.6f кг/с%n",
                ion.getShipName(), ion.getTotalThrustKn(), ion.getInitialAcceleration(), ion.getTotalFuelBurnRate());
    }

    static void task35() {
        header(35, "LandPlot");
        LandPlot plot = new LandPlot(1000); // максимум 600 м2 забудови
        System.out.println("Будинок 10x20 (200 м2): " + plot.addStructure(new RectangleShape("білий", 10, 20)));
        System.out.println("Басейн r=8 (~201 м2):   " + plot.addStructure(new CircleShape("блакитний", 8)));
        System.out.println("Гараж 15x15 (225 м2):   " + plot.addStructure(new RectangleShape("сірий", 15, 15)));
        System.out.printf("Забудовано: %.2f м2, вільно під зелень: %.2f м2%n",
                plot.getBuiltArea(), plot.getFreeGreenArea());
    }

    static void task36() {
        header(36, "InvestmentPortfolio");
        InvestmentPortfolio pf = new InvestmentPortfolio("Андрій");
        pf.addAsset(new GovernmentBond("ОВДП-2027", 100000));
        pf.addAsset(new DividendStock("AAPL", 50000, 0.08, 0.02));
        System.out.printf("Інвестовано: %.2f грн%n", pf.getTotalInvested());
        System.out.printf("Очікуваний прибуток за рік: %.2f грн%n", pf.getExpectedAnnualProfit());
        System.out.printf("Вартість через рік: %.2f грн%n", pf.getValueAfterYear());
    }

    static void task37() {
        header(37, "RaidParty");
        RaidParty party = new RaidParty("Нічні Вартові");
        party.addMember(new ArcaneMage("Мерлін", 600, 120, 80));
        party.addMember(new ArcaneMage("Герміона", 550, 130, 70));
        System.out.println("Загін без танка, сила " + party.getTotalPower()
                + ", готовий до складності 300: " + party.isReadyForRaid(300));
        party.addMember(new TankWarrior("Конан", 1200, 90));
        System.out.println("Загін з танком, сила " + party.getTotalPower()
                + ", готовий до складності 300: " + party.isReadyForRaid(300));
        System.out.println("Готовий до складності 2000: " + party.isReadyForRaid(2000));
    }

    static void task38() {
        header(38, "SmartLab");
        SmartLab lab = new SmartLab();
        PressureSensor p = new PressureSensor("Реактор", 1.0, 6.0, 1.0);
        RadiationSensor r = new RadiationSensor("Вхід", 0.0, 0.3);
        p.setRawReading(4.5);
        r.setMicroSvPerHour(0.1);
        lab.addSensor(p);
        lab.addSensor(r);
        System.out.println("Діагностика 1:");
        lab.runDiagnostics();
        r.setMicroSvPerHour(1.4);
        System.out.println("Діагностика 2:");
        lab.runDiagnostics();
    }

    static void task39() {
        header(39, "SignalProcessor");
        SignalProcessor proc = new SignalProcessor(new AmplifierFilter(2.5), new ClippingFilter(5.0));
        double[] input = {1.0, 2.0, -3.0, 0.5};
        double[] output = proc.process(input);
        System.out.println("Вхід:  " + Arrays.toString(input) + " (не змінився)");
        System.out.println("Вихід: " + Arrays.toString(output));
    }

    static void task40() {
        header(40, "Фіксація роботи в Git");
        System.out.println("Перевірте перед здачею:");
        System.out.println("  1. Код компілюється (Build -> Rebuild Project).");
        System.out.println("  2. Усі 40 завдань виконано, домашня робота в практиці 09 -> homework.");
        System.out.println("  3. Команди:");
        System.out.println("     git status");
        System.out.println("     git add src/semester1/practice09/");
        System.out.println("     git commit -m \"feat(practice09): complete composition, encapsulation and abstract classes tasks\"");
        System.out.println("     git push");
    }
}
