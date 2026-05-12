import { useEffect, useMemo } from 'react'
import { useLocalStorage } from '../../hooks/useLocalStorage'
import type { ThemeMode } from '../../lib/types'
import { ThemeContext } from './themeContext'

const STORAGE_KEY = 'tecback:theme'

export function ThemeProvider({ children }: { children: React.ReactNode }) {
  const [theme, setTheme] = useLocalStorage<ThemeMode>(STORAGE_KEY, 'light')

  useEffect(() => {
    document.documentElement.dataset.theme = theme
  }, [theme])

  const value = useMemo(() => ({ theme, setTheme }), [theme, setTheme])

  return <ThemeContext.Provider value={value}>{children}</ThemeContext.Provider>
}
