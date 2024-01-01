package data;

public class SingleBiometricData {
    byte[] data;
    public SingleBiometricData(byte[] data){
        this.data = data;
    }

    public boolean compare(SingleBiometricData data1){
        if (data1.data.length==data.length){
            for (int i=0; i<data1.data.length;i++){
                if (data1.data[i]!=data[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
