package data;

public class SingleBiometricData {
    byte[] data;
    public SingleBiometricData(byte[] data){
        this.data = data;
    }

    public boolean equals(SingleBiometricData data1, SingleBiometricData data2){
        if (data1.data.length==data2.data.length){
            for (int i=0; i<data1.data.length;i++){
                if (data1.data[i]!=data2.data[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
