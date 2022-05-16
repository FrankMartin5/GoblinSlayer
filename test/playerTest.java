import com.goblinslayer.player.Player;
import com.goblinslayer.player.Weapon;
import org.junit.Before;

public class playerTest {
    private Player player;
    
    @Before
    public void setUp() {
        player = new Player("p1", 50, Weapon.AXE, player.getPower());
    }
}
