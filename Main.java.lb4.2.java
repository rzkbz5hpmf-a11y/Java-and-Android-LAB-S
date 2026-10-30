import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static boolean isBossStunned = false;

    public static int[] heroesHealth = {290, 270, 250, 250, 400, 220, 230, 260};
    public static int[] heroesDamage = {20, 15, 10, 0, 5, 10, 15, 20};
    public static String[] heroesAttackType = {
            "Physical", "Mental", "Magical", "Medic", "Golem", "Lucky", "Berserk", "Thor"
    };

    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        
        if (!isBossStunned) {
            bossAttacks();
        } else {
            System.out.println("Босс оглушен и пропускает этот раунд!");
            isBossStunned = false;
        }

        heroesAttack();
        medicHeal();
        printStatistics();
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossAttacks() {
        Random random = new Random();
        
        // Индексы игроков
        int golemIndex = 4;
        int luckyIndex = 5;
        int berserkIndex = 6;

        // Расчет урона от Голема
        int golemShield = bossDamage / 5;
        int aliveHeroesForGolem = 0;

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (i == golemIndex) continue; // Голем не берет урон сам за себя

                int currentDamage = bossDamage;

                // 1. Способность Lucky (уклонение)
                if (i == luckyIndex && random.nextBoolean()) {
                    System.out.println("Lucky уклонился от удара босса!");
                    continue;
                }

                // 2. Способность Berserk (блокировка и контратака)
                if (i == berserkIndex) {
                    int blockedDamage = 10 + random.nextInt(15); // Блокирует от 10 до 24 урона
                    currentDamage -= blockedDamage;
                    heroesDamage[berserkIndex] = 15 + blockedDamage; // Прибавляет заблокированный урон
                    System.out.println("Berserk заблокировал " + blockedDamage + " урона!");
                }

                // Учитываем Голема
                if (heroesHealth[golemIndex] > 0) {
                    currentDamage -= golemShield;
                    aliveHeroesForGolem++;
                }

                // Нанесение урона герою
                if (heroesHealth[i] - currentDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] -= currentDamage;
                }
            }
        }

        // Голем получает принятый на себя урон
        if (heroesHealth[golemIndex] > 0) {
            int totalGolemDamage = golemShield * aliveHeroesForGolem + bossDamage;
            if (heroesHealth[golemIndex] - totalGolemDamage < 0) {
                heroesHealth[golemIndex] = 0;
            } else {
                heroesHealth[golemIndex] -= totalGolemDamage;
            }
            System.out.println("Golem принял на себя по " + golemShield + " урона за каждого живого героя!");
        }
    }

    public static void heroesAttack() {
        Random random = new Random();
        int thorIndex = 7;

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int damage = heroesDamage[i];

                if (heroesAttackType[i].equals(bossDefence)) {
                    int coefficient = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    damage = heroesDamage[i] * coefficient;
                    System.out.println("Критический урон: " + damage + " (" + heroesAttackType[i] + ")");
                }

                // Способность Thor (оглушение)
                if (i == thorIndex && random.nextBoolean()) {
                    isBossStunned = true;
                    System.out.println("Thor оглушил Босса на 1 раунд!");
                }

                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth -= damage;
                }
            }
        }
    }

    public static void medicHeal() {
        int medicIndex = 3;
        if (heroesHealth[medicIndex] <= 0) {
            return; // Медик мертв
        }

        int healAmount = 30; // N-ное количество здоровья для лечения

        for (int i = 0; i < heroesHealth.length; i++) {
            if (i != medicIndex && heroesHealth[i] > 0 && heroesHealth[i] < 100) {
                heroesHealth[i] += healAmount;
                System.out.println("Medic вылечил " + heroesAttackType[i] + " на " + healAmount + " HP");
                break; // Лечит только одного за раунд
            }
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Герои победили!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int health : heroesHealth) {
            if (health > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Босс победил!");
            return true;
        }

        return false;
    }

    public static void printStatistics() {
        System.out.println("ROUND " + roundNumber + " ---------------");
        System.out.println("Boss health: " + bossHealth + " damage: " + bossDamage +
                " defence: " + (bossDefence == null ? "No defence" : bossDefence));

        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] +
                    " damage: " + heroesDamage[i]);
        }
    }
}
