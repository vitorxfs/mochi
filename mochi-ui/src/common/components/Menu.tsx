import { AnimatePresence, motion } from 'motion/react';
import React, { useState } from 'react'

export function Root({ children }: { children: React.ReactNode }) {
  return (
    <nav>
      <ul className="flex flex-col gap-2">
        {children}
      </ul>
    </nav>
  )
}

export function Item({
  children,
  name,
  color,
  defaultOpen=false,
}: {
  children: React.ReactNode;
  name: string;
  color: string;
  defaultOpen?: boolean;
}) {
  const [expanded, setExpanded] = useState(defaultOpen);

  const handleToggleExpand = () => {
    setExpanded((prev) => !prev);
  }

  return (
    <li aria-expanded={expanded}>
      <button
        onClick={() => handleToggleExpand()}
        className={`flex justify-between w-full border rounded-lg px-5 py-3`}
        style={{ borderColor: color, color }}
      >
        <span>{name}</span>
        <span
          className={`font-icon ${expanded ? 'rotate-0' : 'rotate-180'} transition-transform`}
          aria-hidden
        >
          keyboard_arrow_up
        </span>
      </button>
      <AnimatePresence>
        {expanded && (
          <motion.div
            initial={{opacity: 0, height: 0}}
            animate={{opacity: 1, height: 'auto'}}
            exit={{opacity: 0, height: 0}}
          >
            <div className="px-5 py-6">
              {children}
            </div>
          </motion.div>
        )}
      </AnimatePresence>
    </li>
  )
}
