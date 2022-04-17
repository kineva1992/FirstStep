package com.Sound;

import javax.sound.midi.*;

public class MiniMusicCmdLine {

    public static void main(String[] args)
    {
        args[0] = "102";
        args[1] = "40";
        MiniMusicCmdLine cmd = new MiniMusicCmdLine();
        if(args.length < 2)
            System.out.println("Не забудте аргументы для инструмента и ноты");
        else
        {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            cmd.play(instrument,note);
        }
    }

    public void play(int instrument, int note){
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent charchInstrument = new MidiEvent(first,1);
            track.add(charchInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1, note,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }
}
