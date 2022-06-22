import '../styles/globals.css'

const supportedChainIds = [4]
const connectors = {
  injected: {},
}

function MyApp({ Component, pageProps }) {
  return <> <Component {...pageProps} /> </>

}

export default MyApp
