package ar.edu.itba.ss;


import ar.edu.itba.ss.simulation.methods.BrownianMovement;
import ar.edu.itba.ss.simulation.models.Particle;
import ar.edu.itba.ss.simulation.models.ParticleGenerator;
import ar.edu.itba.ss.simulation.models.PotentialCrash;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class BrownianMovementTest {

    @Test
    public void testTime(){
        double L = 0.5;
        List<Particle> particles = ParticleGenerator.particlesGenerator(100, 0.1, 0.05, 0.005, 3, L,0.1, L/2, L/2);
        BrownianMovement move = new BrownianMovement(0.5, particles);

        for (Particle particle : particles) {
            move.timeCrashParticleToWall(particle);
            for (Particle particle1 : particles) {
                move.timeCrashParticleToParticle(particle, particle1);
            }
        }
        for (PotentialCrash c: move.getCrashTimes()) {
            assertTrue(c.getTime()>=0);
        }
    }
}
