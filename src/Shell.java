import java.lang.StringBuilder;
import java.util.LinkedList;

public class Shell {

    public static void main(String[] args) {
        System.out.println("hello! :3");
        StringBuilder sb = new StringBuilder();
        sb.append("Some die roll tests...\n");
        sb.append("===D4\n");
        for (int i = 0; i < 5; i++) {
            sb.append(Die.roll(4) + "\n");
        }
        sb.append("===2D20\n");
        for (int i = 0; i < 100; i++) {
            sb.append(Die.roll(20, 20) + "\n");
        }
        System.out.println(sb);

        Input playerInfo = new Input("test/players.json");
        System.out.println(playerInfo);
        LinkedList<Creature> players = playerInfo.getPlayers();
        LinkedList<Creature> enemies = playerInfo.getEnemies();

        Attack attack = new Attack("Sword Slash", AttackType.MELEE, DamageType.SLASHING, 1, 6, 1);
        attack.roll();
        System.out.println(attack.describe());
        Attack attack2 = new Attack("Light Crossbow", AttackType.RANGED, DamageType.PIERCING, 1, 6, 1);
        System.out.println(attack2.describe());
        Attack attack3 = new Attack("Greatsword", AttackType.RANGED, DamageType.PIERCING, 2, 6, 3);
        attack3.roll();
        System.out.println(attack3.describe());

        Combat combat = new Combat(players, enemies);
        System.out.println(combat.toPrettyString());
        System.out.println("Players alive: " + combat.playersAlive());
        System.out.println("Enemies alive: " + combat.enemiesAlive());

    }

}