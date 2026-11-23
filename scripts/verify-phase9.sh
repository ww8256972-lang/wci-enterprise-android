#!/data/user/0/ai.antigem/files/usr/bin/bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
echo "=== Phase 9 Verification ==="
echo "Kotlin files: $(find "$ROOT" -name '*.kt' | wc -l)"
echo "C++ files: $(find "$ROOT" -name '*.cpp' -o -name '*.h' | wc -l)"
echo "Firebase functions: $(find "$ROOT/cloud-functions/src" -name '*.ts' | wc -l)"
bash "$ROOT/scripts/verify-no-web.sh"
echo "No TODO stubs check:"
if grep -R "TODO" "$ROOT" --include=*.kt --include=*.cpp --include=*.ts 2>/dev/null | grep -q .; then
  echo "WARNING: TODO found"
else
  echo "PASS: no TODO markers"
fi
echo "=== Verification complete ==="