/** @type {import('next').NextConfig} */
module.exports = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: `http://${process.env.backend_URL}:8080/api/:path*`,
      },
    ]
  },
}
