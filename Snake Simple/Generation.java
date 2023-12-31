public class Generation
{
    private double[][] layerIn;
    private double[][] layerHidden;
    private double[][] layerOut;
    private double[] biasIn;
    private double[] biasHidden;
    private double[] biasOut;
    public Generation(double[][] pLayerIn, double[][] pLayerHidden, double[][] pLayerOut, double[] pBiasIn, double[] pBiasHidden, double[] pBiasOut)
    {
        layerIn = pLayerIn;
        layerHidden = pLayerHidden;
        layerOut = pLayerOut;
        biasIn = pBiasIn;
        biasHidden = pBiasHidden;
        biasOut = pBiasOut;
    }
    public double[][] getLayerIn()
    {
        return layerIn;
    }
    public double[][] getLayerHidden()
    {
        return layerHidden;
    }
    public double[][] getLayerOut()
    {
        return layerOut;
    }
    public double[] getBiasIn()
    {
        return biasIn;
    }
    public double[] getBiasHidden()
    {
        return biasHidden;
    }
    public double[] getBiasOut()
    {
        return biasOut;
    }
}