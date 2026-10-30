public class Main {
    public static void main(String[] args) {
        // Задание 3. Создание и вывод информации о монстре
        Monster monster = new Monster();
        monster.setHealth(500);
        monster.setDamage(45);
        monster.setType("Огр");

        System.out.println("=== ИНФОРМАЦИЯ О МОНСТРЕ ===");
        System.out.println("Здоровье: " + monster.getHealth());
        System.out.println("Урон: " + monster.getDamage());
        System.out.println("Тип: " + monster.getType());

        System.out.println("
=== ИНФОРМАЦИЯ ОБ ИГРОКАХ ===");
        // Задание 4. Вызов createPlayers() и вывод с помощью цикла
        Player[] players = createPlayers();
        for (Player player : players) {
            System.out.println("Игрок -> Уровень: " + player.getLevel() +
                               ", Урон: " + player.getDamage() +
                               ", Оружие: " + player.getWeapon());
        }
    }

    // Задание 4. Метод createPlayers()
    public static Player[] createPlayers() {
        Player player1 = new Player(10, 50, "Меч Светлоносца");
        Player player2 = new Player(15, 75, "Лук ЭЛЬФОВ");
        Player player3 = new Player(5, 20); // Использование второго конструктора

        return new Player[]{player1, player2, player3};
    }
}
