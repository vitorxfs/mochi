import { RouterProvider } from 'react-router-dom'
import { router } from './routes'
import './baseStyles.css';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';


const queryClient = new QueryClient()

function App() {
  return (
    <QueryClientProvider  client={queryClient}>
      <RouterProvider router={router}/>
    </QueryClientProvider>
  )
}

export default App
