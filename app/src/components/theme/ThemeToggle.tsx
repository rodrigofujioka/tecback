import { useTheme } from '../../app/providers/useTheme'
import type { ThemeMode } from '../../lib/types'

const options: Array<{ label: string; value: ThemeMode }> = [
  { label: 'Tema normal', value: 'light' },
  { label: 'Tema dark', value: 'dark' },
]

export function ThemeToggle() {
  const { theme, setTheme } = useTheme()

  return (
    <div className="theme-toggle" aria-label="Selecionar tema da interface">
      {options.map((option) => (
        <button
          key={option.value}
          type="button"
          className={`theme-toggle__button ${theme === option.value ? 'is-active' : ''}`}
          onClick={() => setTheme(option.value)}
        >
          {option.label}
        </button>
      ))}
    </div>
  )
}

