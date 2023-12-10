import zio.{ZIOAppDefault, ExitCode, URIO}

object App extends ZIOAppDefault {
  def run: URIO[Any, ExitCode] = {
    FungalServer.run
  }
}
