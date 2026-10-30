public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.setHealth(1000);
        boss.setDamage(80);
        boss.setDefenceType("Magical");

        System.out.println("=== ИНФОРМАЦИЯ О БОССЕ ===");
        System.out.println("Здоровье босса: " + boss.getHealth());
        System.out.println("Урон босса: " + boss.getDamage());
        System.out.println("Тип защиты босса: " + boss.getDefenceType());

        System.out.println("
=== ИНФОРМАЦИЯ О ГЕРОЯХ ===");
        Hero[] heroes = createHeroes();
        for (Hero hero : heroes) {
            System.out.println("Герой -> Здоровье: " + hero.getHealth() + 
                               ", Урон: " + hero.getDamage() + 
                               ", Суперспособность: " + hero.getSuperpower());
        }
    }

    public static Hero[] createHeroes() {
        Hero hero1 = new Hero(270, 20, "Physical");
        Hero hero2 = new Hero(250, 15, "Kinetic");
        Hero hero3 = new Hero(300, 25);

        Hero[] heroesArray = {hero1, hero2, hero3};
        return heroesArray;
    }
}
