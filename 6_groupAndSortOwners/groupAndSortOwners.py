from collections import defaultdict

def groupAndSortOwners(file_owners):
    
    owner_files = defaultdict(list)
    

    for file, owner in file_owners.items():
        owner_files[owner].append(file)
    
    
    for owner in owner_files:
        owner_files[owner].sort(key=str.lower)
    
    return dict(owner_files)

file_owners = {
    'Input.txt': 'Albert',
    'Code.py': 'Stanley',
    'Output.txt': 'Albert',
    'btech.txt': 'Albert'
}

result = groupAndSortOwners(file_owners)
print(result)
