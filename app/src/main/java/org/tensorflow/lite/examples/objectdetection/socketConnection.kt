package org.tensorflow.lite.examples.objectdetection

import android.os.NetworkOnMainThreadException
import android.system.Os.socket
import android.util.Log
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketAddress


class socketConnection {

    var isConnected = false
    var host = "192.168.1.11"
    var port = 4000
    var mSocket = Socket();
    val inetAddress: InetAddress = InetAddress.getByName(host)
    val socketAddress: SocketAddress = InetSocketAddress(inetAddress, port)



    constructor(){
        connect()
    }



    fun connect (){
        Thread(Runnable {
            try {
                Log.i("socket","connecting...")
                //mSocket.connect(socketAddress,20000)
                mSocket= Socket(host,port);
                isConnected=true
                Log.i("socket","connected")

            } catch (e: NetworkOnMainThreadException) {
                isConnected=false
                Log.e("sockCons",e.toString())
            } catch (e: Exception){
                isConnected=false
                Log.e("sockConst",e.toString())
            }
        }).start()
    }

    fun sendData (dataTest: String){
        Thread(Runnable {
            try {
                //Log.i("socket","connected")

                //Log.i("socket","sendind data:" + dataTest.toString())
                mSocket.getOutputStream().write(dataTest.toByteArray())
                mSocket.getOutputStream().flush()
                //mSocket.getOutputStream().write("\\n".toByteArray())
                Log.i("socket","data sent")

            } catch (e: NetworkOnMainThreadException) {
                isConnected=false
                Log.e("socket",e.toString())
            } catch (e: Exception){
                isConnected=false
                Log.e("socketAll",e.toString())
                connect()
            }
        }).start()

    }

    fun sendImageByteArray (imgByteArray: ByteArray){
        Thread(Runnable {
            try {
                //Log.i("socket","connected")

                //Log.i("socket","sendind data:" + dataTest.toString())
                mSocket.getOutputStream().write("IMAGE;".toByteArray()+imgByteArray)
                //mSocket.getOutputStream().write("\\n".toByteArray())
                Log.i("socket","data sent")

            } catch (e: NetworkOnMainThreadException) {
                isConnected=false
                Log.e("socket",e.toString())
            } catch (e: Exception){
                isConnected=false
                Log.e("socketAll",e.toString())
                connect()
            }
        }).start()

    }




    fun sendDataOpeningSocket (data: String){
        Thread(Runnable {
            try {
                Log.i("socket","connecting...")
                //mSocket.connect(socketAddress,20000)
                mSocket= Socket(host,port);
                //Log.i("socket","connected")
                Log.i("socket","sendind data")
                mSocket.getOutputStream().write(data.toByteArray())
                Log.i("socket","data sent")

            } catch (e: NetworkOnMainThreadException) {
                Log.e("socket",e.toString())
            } catch (e: Exception){
                Log.e("socketAll",e.toString())
            }
        }).start()
    }

    fun sendByteArrayOpeningSocket (byteArray: ByteArray){
        Thread(Runnable {
            try {
                Log.i("socket","connecting...")
                //mSocket.connect(socketAddress,20000)
                mSocket= Socket(host,port);
                //Log.i("socket","connected")
                Log.i("socket","sendind data")
                mSocket.getOutputStream().write(byteArray)
                Log.i("socket","data sent")

            } catch (e: NetworkOnMainThreadException) {
                Log.e("socket",e.toString())
            }
        }).start()
    }

    //@Synchronized
    fun setSocket() {
        Thread(Runnable {
            try {
// "http://10.0.2.2:3000" is the network your Android emulator must use to join the localhost network on your computer
// "http://localhost:3000/" will not work
// If you want to use your physical phone you could use the your ip address plus :3000
// This will allow your Android Emulator and physical device at your home to connect to the server
                // mSocket = IO.socket("http://10.0.2.2:3000")
                //val client = Socket("192.168.1.13",21567)
                Log.i("socket","connecting...")
                mSocket.connect(socketAddress,20000)
                //mSocket= Socket("192.168.1.10",21567);
                //mSocket.connect()
                Log.i("socket","connected")

            } catch (e: NetworkOnMainThreadException) {
                Log.e("socket",e.toString())
            }
        }).start()

    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }


    @Synchronized
    fun closeConnection() {
        mSocket.close()
    }
}