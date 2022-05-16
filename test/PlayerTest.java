import com.goblinslayer.character.Player;
import com.goblinslayer.character.Weapon;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    
    @Before
    public void setUp() {
        player = new Player("p1", 50, Weapon.AXE);
    }

    @Test
    public void testAttack() {
    }

    @Test
    public void testDefend() {
    }
}
