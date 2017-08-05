package net.test.chapter09_interface.filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double hightCut)
    {
        this.lowCutoff = lowCut;
        this.highCutoff = hightCut;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
