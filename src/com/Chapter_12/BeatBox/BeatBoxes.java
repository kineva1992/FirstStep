package com.Chapter_12.BeatBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BeatBoxes {
    private static final int COUNT = 16;
    private static int selected = 0;
    private JFrame frame;
    private JPanel mainPanel;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private ArrayList<JCheckBox> checkBoxList;
    private JCheckBox[] checkBox = new JCheckBox[256];
    private JButton upTempo;
    private JButton downTempo;

    private String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat","Open Hi-Hat", "Acoutstic Share",
            "Crash Cymbal","Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Comga",
            "Cowbell", "Vibraslap", 	"Low-mid Tom", "High Agogo", "Open Hi Conga"};

    private int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args)
    {
        new BeatBoxes().buildGUI();
    }

    @SuppressWarnings("unused")
    public void buildGUI() {
        this.frame = new JFrame("BeatBox");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.checkBoxList = new ArrayList<JCheckBox>();
        BorderLayout layout = new BorderLayout();
        JPanel backGround = new JPanel(layout);
        backGround.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        this.upTempo = new JButton("Up Tempo");
        this.upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(this.upTempo);

        this.downTempo = new JButton("Down Tempo");
        this.downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(this.downTempo);

        JButton removeTick = new JButton("Remove Tick");
        removeTick.addActionListener(new MyRemoveTickListener());
        buttonBox.add(removeTick);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(int i = 0; i < 16; i++) {
            nameBox.add(new Label(this.instrumentNames[i]));
        }
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        this.mainPanel = new JPanel(grid);
        for(int x = 0; x < 256; x++) {
            this.checkBox[x] = new JCheckBox();
            this.checkBox[x].setSelected(false);
            this.checkBoxList.add(this.checkBox[x]);
            this.mainPanel.add(this.checkBox[x]);
        }
        for(int i = 0; i < checkBoxList.size(); i++) {
            checkBoxList.get(i).addItemListener(new MyItemListener());
        }
        backGround.add(BorderLayout.EAST, buttonBox);
        backGround.add(BorderLayout.WEST, nameBox);
        backGround.add(BorderLayout.CENTER, mainPanel);
        this.frame.getContentPane().add(backGround);
        this.buildMidi();
        this.frame.setBounds(50, 50, 500, 500);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    public void buildMidi() {
        try {
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.open();
            this.sequence = new Sequence(Sequence.PPQ, 4);
            this.track = sequence.createTrack();
            this.sequencer.setTempoInBPM(120);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings({ "unused", "static-access" })
    public void buildStart() {
        int[] trackList = null;
        this.sequence.deleteTrack(track);
        this.track = sequence.createTrack();
        for(int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for(int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox)this.checkBoxList.get(j + i * 16);
                if(jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            this.makeTracks(trackList);
        }
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            buildStart();
        }
    }
    public class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            sequencer.stop();
        }
    }
    public class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }
    public class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 0.97));
        }
    }
    public class MyRemoveTickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            for(int i = 0; i < 256; i++) {
                if(checkBox[i].isSelected()) {
                    checkBox[i].setSelected(false);
                    mainPanel.repaint();
                }
            }
        }
    }
    public class MyItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // TODO Auto-generated method stub
            JCheckBox jc = (JCheckBox)e.getSource();
            if(jc.isSelected()) {
                selected++;
                if(selected > 16) {
                    jc.setSelected(false);
                }
            } else {
                selected--;
            }
        }
    }
    public void makeTracks(int[] list) {
        for(int i = 0; i < 16; i++) {
            int key = list[i];
            if(key != 0) {
                this.track.add(makeEvent(144, 9, key, 100, i));
                this.track.add(makeEvent(128, 9, key, 100, i+1));
            }
        }
    }
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(comd, chan, one, two);
            event = new MidiEvent(message, tick);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }
}