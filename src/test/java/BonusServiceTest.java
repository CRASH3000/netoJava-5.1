import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void TestReg() {
        BonusService service = new BonusService();

        // тест на проверку процента зарегистрованного пользователя (3%)
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestNoReg() {
        BonusService service = new BonusService();

        // тест на проверку процента не зарегистрованного пользователя (1%)
        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestReg_Max() {
        BonusService service = new BonusService();

        // тест на проверку максимального значения бонусов (3%)
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestNoReg_Max() {
        BonusService service = new BonusService();

        // тест на проверку максимального значения бонусов (1%)
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestLimitReg_Max() {
        BonusService service = new BonusService();

        // тест на проверку достижения максимального кол-ва баллов без переодоления лимита (3%)
        long amount = 16_667;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestLimitNoReg_Max() {
        BonusService service = new BonusService();

        // тест на проверку достижения максимального кол-ва баллов без переодоления лимита (1%)
        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestReg_zero() {
        BonusService service = new BonusService();

        // тест на проверку получения бонусов с 0 чеком (3%)
        long amount = 0;
        boolean registered = true;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestNoReg_zero() {
        BonusService service = new BonusService();

        // тест на проверку получения бонусов с 0 чеком (1%)
        long amount = 0;
        boolean registered = false;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestReg_NegCheck() {
        BonusService service = new BonusService();

        // тест на проверку получения бонусов с отрицательным чеком (3%)
        long amount = -100;
        boolean registered = true;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void TestNoReg_NegCheck() {
        BonusService service = new BonusService();

        // тест на проверку получения бонусов с отрицательным чеком (1%)
        long amount = -100;
        boolean registered = false;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }


}
