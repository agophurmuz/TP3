package ar.edu.itba.ss;

import ar.edu.itba.ss.simulation.models.Particle;
import ar.edu.itba.ss.simulation.models.ParticleGenerator;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ParticleGeneratorTest {

    @Test
    public void testParticleGenerator(){
        double L = 0.5;
        List<Particle> particles = ParticleGenerator.particlesGenerator(100, 0.1, 0.05, 0.005, 3, L,0.1, L/2, L/2);

        for (Particle p: particles) {
            assertTrue(p.getX()< L && p.getY()<L);
        }
    }
}
