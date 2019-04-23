import "github.com/noamt/stop"

stopChannel := make(chan string)
stop.ListenForStopSignal(stopChannel)

_ = <-stopChannel
// Do stuff
stop.SignalThatProcessHasStopped()