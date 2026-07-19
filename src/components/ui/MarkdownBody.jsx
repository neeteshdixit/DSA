import { useEffect } from 'react';
import ReactMarkdown from 'react-markdown';
import remarkGfm from 'remark-gfm';
import Prism from 'prismjs';
import 'prismjs/components/prism-java';
import 'prismjs/components/prism-javascript';
import 'prismjs/components/prism-jsx';
import 'prismjs/components/prism-bash';
import 'prismjs/components/prism-json';
import 'prismjs/components/prism-markdown';
import { toSlug } from '@/lib/format';

function normalizeText(children) {
  return Array.isArray(children) ? children.join('') : String(children ?? '');
}

function Heading({ level, children, ...props }) {
  const TagName = `h${level}`;
  const text = normalizeText(children);
  const id = toSlug(text);
  return (
    <TagName id={id} {...props}>
      {children}
    </TagName>
  );
}

export default function MarkdownBody({ children }) {
  useEffect(() => {
    Prism.highlightAll();
  }, [children]);

  return (
    <div className="prose-lite">
      <ReactMarkdown
        remarkPlugins={[remarkGfm]}
        components={{
          h1: ({ children, ...props }) => <Heading level={1} {...props}>{children}</Heading>,
          h2: ({ children, ...props }) => <Heading level={2} {...props}>{children}</Heading>,
          h3: ({ children, ...props }) => <Heading level={3} {...props}>{children}</Heading>,
          h4: ({ children, ...props }) => <Heading level={4} {...props}>{children}</Heading>,
          a: ({ children, ...props }) => (
            <a {...props} className="text-sky-300 underline decoration-sky-300/50 underline-offset-4">
              {children}
            </a>
          ),
          table: ({ children, ...props }) => (
            <div className="overflow-x-auto">
              <table {...props}>{children}</table>
            </div>
          ),
          code: ({ inline, className, children, ...props }) => {
            if (inline) {
              return (
                <code className={className} {...props}>
                  {children}
                </code>
              );
            }

            return (
              <pre className={className}>
                <code {...props}>{children}</code>
              </pre>
            );
          },
        }}
      >
        {children}
      </ReactMarkdown>
    </div>
  );
}
