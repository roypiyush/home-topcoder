package HelloApp;


/**
* HelloApp/HelloPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hello.idl
* Friday, 7 February, 2014 11:33:02 PM IST
*/

public class HelloPOATie extends HelloPOA
{

  // Constructors

  public HelloPOATie ( HelloApp.HelloOperations delegate ) {
      this._impl = delegate;
  }
  public HelloPOATie ( HelloApp.HelloOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public HelloApp.HelloOperations _delegate() {
      return this._impl;
  }
  public void _delegate (HelloApp.HelloOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public String sayHello ()
  {
    return _impl.sayHello();
  } // sayHello

  public void shutdown ()
  {
    _impl.shutdown();
  } // shutdown

  private HelloApp.HelloOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class HelloPOATie
