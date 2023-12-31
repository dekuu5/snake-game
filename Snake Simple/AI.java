public class AI  
{/*
    private boolean start = false;
    private InNeuron[] layerIn;
    private Neuron[] layerHidden;
    private OutNeuron[] layerOut;
    private Head snake;
    private int gen;
    private int out;
    private Generation genType;


    public void start()
    {

    }

    public void run()
    {
        double[] temp = new double[3];
        for(int i = 0; i!=5; i++)layerIn[i].setValue(getInput(i));
        for(int i = 0; i!=5; i++)temp[i] = layerIn[i].getValue;
        for(int i = 0; i!=3; i++)layerHidden[i].setInput(temp);
        for(int i = 0; i!=3; i++)temp[i] = layerHidden[i].out();
        for(int i = 0; i!=3; i++)layerOut[i].setInput[i];
        if(layerOut[0]>layerOut[1]&&layerOut[0]>layerOut[2])out = -1;
        else if(layerOut[1]>layerOut[2])out = 0;
        else out = 1;
    }




    public AI()
    {
        for(int i = 0; i!=5; i++)layerIn[i] = new InNeuron();
        for(int i = 0; i!=3; i++)layerHidden[i] = new Neuron({Math.random()*2-1, Math.random()*2-1, Math.random()*2-1}, Math.random*2-1);
        for(int i = 0; i!=3; i++)layerOut[i] = new OutNeuron({Math.random()*2-1, Math.random()*2-1, Math.random()*2-1}, Math.random*2-1);
        snake = new Head(true);
        gen = 1;
        saveGen();
    }
    public AI(int generation, )
    {
        gen = generation;
        saveGen;
    }






    
    getInput(int i)
    {
        if(i==0)
        {
            return
        }
        else if(i==1)
        {
            return
        }
        else if(i==2)
        {
            return
        }
        else if(i==3)
        {
            return
        }
        else
        {
            return
        }
    }
    public void saveGen()
    {
        double[][]temp0 = 
        double[][]temp1 = 
        double[][]temp2 = 
        double[]temp3 = 
        double[]temp4 = 
        double[]temp5 = 
        getType = new Generation(temp0, temp1, temp2, temp3, temp4, temp5);
    }

    public void act()
    {
        if(start)start();
        start=false;
        run();
    }

    private class Neuron
    {
        private double[] wheight;
        private double bias;
        private double temp;
        private double[] input;
        Neuron(double[] pWheight, double pBias)
        {
            wheigth = pWheight;
            bias = pBias;
        }
        protected double[] getWheight()
        {
            return wheight[];
        }
        protected double getBias()
        {
            return bias;
        }
        protected void setWheight(double[] pWheight)
        {
            wheight = pWheight;
        }
        protected void setBias(double pBias)
        {
            bias = pBias;
        }
        protected void setInput(double[] pInput)
        {
            input = pInput;
        }
        protected double out()
        {
            temp = 0;
            for(int i : wheight)
            {
                temp += input[i]*wheight[i];
            }
            return 1/(1+Math.pow(Math.E, temp+bias));
        }
    }
    private class InNeuron
    {
        private double value;
        protected double getValue()
        {
            return value;
        }
        protected void setValue(double pValue)
        {
            value = pValue;
        }
    }
    private class OutNeuron
    {
        private double[] wheight;
        private double bias;
        private double temp;
        private double[] input;
        OutNeuron(double pWheight, double pBias)
        {
            wheight = pWheight;
            bias = pBias;
        }
        protected double[] getWheight()
        {
            return wheight[];
        }
        protected double getBias()
        {
            return bias;
        }
        protected void setWheight(double[] pWheight)
        {
            wheight = pWheight;
        }
        protected void setBias(double pBias)
        {
            bias = pBias;
        }
        protected void setInput(double[] pInput)
        {
            input = pInput;
        }
        protected double out()
        {
            temp = 0;
            for(int i : wheight)
            {
                temp += input[i]*wheight[i];
            }
            return temp + bias;
        }
    }
    */
}