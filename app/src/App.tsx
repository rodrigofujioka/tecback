import { useMemo, useState } from 'react'
import { ThemeProvider } from './app/providers/ThemeProvider'
import { AppShell } from './components/layout/AppShell'
import { TabNav } from './components/navigation/TabNav'
import { EndpointsTab } from './features/endpoints/EndpointsTab'
import { OverviewTab } from './features/overview/OverviewTab'
import { SuggestionsTab } from './features/suggestions/SuggestionsTab'
import { TeamTab } from './features/team/TeamTab'
import type { TabKey } from './lib/types'

function AppContent() {
  const [activeTab, setActiveTab] = useState<TabKey>('overview')

  const currentTab = useMemo(() => {
    switch (activeTab) {
      case 'suggestions':
        return <SuggestionsTab />
      case 'endpoints':
        return <EndpointsTab />
      case 'team':
        return <TeamTab />
      case 'overview':
      default:
        return <OverviewTab />
    }
  }, [activeTab])

  return (
    <AppShell>
      <TabNav activeTab={activeTab} onChange={setActiveTab} />
      {currentTab}
    </AppShell>
  )
}

export default function App() {
  return (
    <ThemeProvider>
      <AppContent />
    </ThemeProvider>
  )
}

