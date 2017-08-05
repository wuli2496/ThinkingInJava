package net.test.chapter09_interface.filters;

import net.test.chapter14_classinfo.HiddenImplementation;

public class HighPass extends Filter {
    double cutoff;
    public HighPass(double cutoff)
    {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
